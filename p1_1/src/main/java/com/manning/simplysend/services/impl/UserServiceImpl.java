package com.manning.simplysend.services.impl;

import com.manning.simplysend.dto.UserDTO;
import com.manning.simplysend.entities.User;
import com.manning.simplysend.exceptions.IncorrectPasswordCharactersException;
import com.manning.simplysend.exceptions.IncorrectPasswordLengthException;
import com.manning.simplysend.exceptions.IncorrectUsernameFormatException;
import com.manning.simplysend.exceptions.UserAlreadyRegisteredException;
import com.manning.simplysend.mappers.UserMapper;
import com.manning.simplysend.repositories.UserRepository;
import com.manning.simplysend.services.UserService;
import com.manning.simplysend.validation.CredentialsValidator;
import com.manning.simplysend.validation.CredentialsValidity;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    private CredentialsValidator credentialsValidator;

    public UserServiceImpl(UserRepository userRepository,
                           CredentialsValidator credentialsValidator) {
        this.userRepository = userRepository;
        this.credentialsValidator = credentialsValidator;
    }

    @Override
    public void createUser(@NonNull UserDTO userDTO) {
        User user = UserMapper.fromDTO(userDTO);


        final CredentialsValidity userNameValidity = credentialsValidator.validateUserName(user.getEmail());
        final CredentialsValidity passwordValidity = credentialsValidator.validatePassword(user.getPassword());

        if(userNameValidity.equals(CredentialsValidity.NOT_VALID_USERNAME_FORMAT)){
            throw new IncorrectUsernameFormatException();
        }

        if(passwordValidity.equals(CredentialsValidity.NOT_VALID_PASSWORD_CHARACTERS)){
            throw new IncorrectPasswordCharactersException();
        }

        if(passwordValidity.equals(CredentialsValidity.NOT_VALID_PASSWORD_LENGTH)){
            throw new IncorrectPasswordLengthException();
        }

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyRegisteredException();
        }

        // TODO: validate username and password and make sure they adhere to our minimum security requirements

        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String hashedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(hashedPassword);

        userRepository.save(user);

        // TODO: encode password here so it doens't get saved as plain text


    }
}
