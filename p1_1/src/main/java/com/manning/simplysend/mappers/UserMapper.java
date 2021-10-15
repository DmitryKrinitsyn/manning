package com.manning.simplysend.mappers;

import com.manning.simplysend.dto.UserDTO;
import com.manning.simplysend.entities.User;

public class UserMapper {

    public static User fromDTO(UserDTO userDTO) {
        User u = new User();
        u.setFirstName(userDTO.getFirstName());
        u.setLastName(userDTO.getLastName());
        u.setEmail(userDTO.getEmailId());
        u.setPassword(userDTO.getPassword());
        return u;
    }

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmailId(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }

}
