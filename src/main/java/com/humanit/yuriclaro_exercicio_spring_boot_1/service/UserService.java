package com.humanit.yuriclaro_exercicio_spring_boot_1.service;

import com.humanit.yuriclaro_exercicio_spring_boot_1.dto.UserAccountDTO;
import com.humanit.yuriclaro_exercicio_spring_boot_1.exception.UserNotFoundException;
import com.humanit.yuriclaro_exercicio_spring_boot_1.mapper.UserMapper;
import com.humanit.yuriclaro_exercicio_spring_boot_1.model.Address;
import com.humanit.yuriclaro_exercicio_spring_boot_1.model.UserAccount;
import com.humanit.yuriclaro_exercicio_spring_boot_1.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserAccountDTO createUser(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = userMapper.toEntity(userAccountDTO);
        List<Address> addresses = userAccountDTO.getAddressDTOS().stream()
                .map(addressDTO -> {
                    Address address = new Address();
                    address.setStreet(addressDTO.getStreet());
                    address.setNumber(addressDTO.getNumber());
                    address.setCity(addressDTO.getCity());
                    address.setState(addressDTO.getState());
                    address.setPostalCode(addressDTO.getPostalCode());
                    address.setCountry(addressDTO.getCountry());
                    address.setUserAccount(userAccount);
                    return address;
                }).collect(Collectors.toList());
        userAccount.setAddresses(addresses);
        userRepository.save(userAccount);
        return userMapper.toDTO(userAccount);
    }

    public Page<UserAccountDTO> getAllUsers(Pageable pageable) {
        Page<UserAccount> userAccounts = userRepository.findAll(pageable);
        logger.log(Level.INFO,"All Users returned successfully");
        return userAccounts.map(userMapper::toDTO);
    }

    public UserAccountDTO getUserById(Long id) {
        UserAccount userAccount = userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found"));
        logger.log(Level.INFO , "UserAccount returned successfully");
        return userMapper.toDTO(userAccount);
    }

    public Page<UserAccountDTO> searchByName(String name, Pageable pageable) {
        Page<UserAccount> userAccounts = userRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name, pageable);
        return userAccounts.map(userMapper::toDTO);
    }

    public UserAccountDTO updateUser(Long id, UserAccountDTO userAccountDTO) {
        UserAccount existingUserAccount = userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found"));
        existingUserAccount.setUsername(userAccountDTO.getUsername());
        existingUserAccount.setPassword(userAccountDTO.getPassword());
        existingUserAccount.setFirstName(userAccountDTO.getFirstName());
        existingUserAccount.setLastName(userAccountDTO.getLastName());
        existingUserAccount.setEmail(userAccountDTO.getEmail());
        existingUserAccount.setPhoneNumber(userAccountDTO.getPhoneNumber());
        existingUserAccount.setBirthDate(userAccountDTO.getBirthDate());
        existingUserAccount.setRole(userAccountDTO.getRole());
        UserAccount updatedUserAccount = userRepository.save(existingUserAccount);
        logger.log(Level.INFO , "UserAccount updated successfully");
        return userMapper.toDTO(updatedUserAccount);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        logger.log(Level.INFO , "UserAccount deleted successfully");
    }

}
