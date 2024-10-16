package com.humanit.yuriclaro_exercicio_spring_boot_1.mapper;

import com.humanit.yuriclaro_exercicio_spring_boot_1.dto.UserAccountDTO;
import com.humanit.yuriclaro_exercicio_spring_boot_1.enumearator.Role;
import com.humanit.yuriclaro_exercicio_spring_boot_1.model.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "role", target = "role", qualifiedByName = "roleToString")
    @Mapping(source = "addresses", target = "addressDTOS")
    UserAccountDTO toDTO(UserAccount userAccount);

    @Mapping(source = "addressDTOS", target = "addresses")
    UserAccount toEntity(UserAccountDTO userAccountDTO);

    @Named("roleToString")
    static String roleToString(Role role) {
        return String.valueOf(role);
    }

}

