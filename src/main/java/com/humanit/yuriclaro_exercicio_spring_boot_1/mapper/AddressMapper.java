package com.humanit.yuriclaro_exercicio_spring_boot_1.mapper;

import com.humanit.yuriclaro_exercicio_spring_boot_1.dto.AddressDTO;
import com.humanit.yuriclaro_exercicio_spring_boot_1.model.Address;
import com.humanit.yuriclaro_exercicio_spring_boot_1.model.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "userAccount", target = "userAccountId", qualifiedByName = "userToId")
    AddressDTO toDto(Address address);

    Address toEntity(AddressDTO addressDTO);

    @Named("userToId")
    static Long userToLong(UserAccount userAccount) {
        return userAccount.getId();
    }
}

