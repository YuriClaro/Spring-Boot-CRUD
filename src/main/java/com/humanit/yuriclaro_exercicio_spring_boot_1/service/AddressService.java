package com.humanit.yuriclaro_exercicio_spring_boot_1.service;

import com.humanit.yuriclaro_exercicio_spring_boot_1.dto.AddressDTO;
import com.humanit.yuriclaro_exercicio_spring_boot_1.exception.AddressNotFoundException;
import com.humanit.yuriclaro_exercicio_spring_boot_1.exception.UserNotFoundException;
import com.humanit.yuriclaro_exercicio_spring_boot_1.mapper.AddressMapper;
import com.humanit.yuriclaro_exercicio_spring_boot_1.model.Address;
import com.humanit.yuriclaro_exercicio_spring_boot_1.model.UserAccount;
import com.humanit.yuriclaro_exercicio_spring_boot_1.repository.AddressRepository;
import com.humanit.yuriclaro_exercicio_spring_boot_1.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public AddressService(AddressRepository addressRepository, UserRepository userRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.addressMapper = addressMapper;
    }

    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toEntity(addressDTO);
        UserAccount userAccount = userRepository.findById(addressDTO.getUserAccountId())
                        .orElseThrow(() -> new UserNotFoundException("User not found"));
        address.setUserAccount(userAccount);
        addressRepository.save(address);
        logger.log(Level.INFO,"Address created successfully");
        return addressMapper.toDto(address);
    }

    public Page<AddressDTO> getAllAddresses(Pageable pageable) {
        Page<Address> addresses = addressRepository.findAll(pageable);
        logger.log(Level.INFO,"Addresses returned successfully");
        return addresses.map(addressMapper::toDto);
    }

    public AddressDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                        .orElseThrow(() -> new AddressNotFoundException("Address not found"));
        logger.log(Level.INFO,"Address returned successfully");
        return addressMapper.toDto(address);
    }

    public Page<AddressDTO> searchByUser(Long id, Pageable pageable) {
        Page<Address> addresses = addressRepository.findByUserAccount_Id(id, pageable);
        return addresses.map(addressMapper::toDto);
    }

    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found"));
        UserAccount userAccount = userRepository.findById(addressDTO.getUserAccountId())
                .orElseThrow(() -> new UserNotFoundException("User id not found"));
        existingAddress.setStreet(addressDTO.getStreet());
        existingAddress.setPostalCode(addressDTO.getPostalCode());
        existingAddress.setCountry(addressDTO.getCountry());
        existingAddress.setCity(addressDTO.getCity());
        existingAddress.setState(addressDTO.getState());
        existingAddress.setNumber(addressDTO.getNumber());
        existingAddress.setUserAccount(userAccount);
        Address updatedAddress = addressRepository.save(existingAddress);
        logger.log(Level.INFO, "Address updated successfully");
        return addressMapper.toDto(updatedAddress);
    }


    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
        logger.log(Level.INFO , "Address deleted successfully");
    }
}
