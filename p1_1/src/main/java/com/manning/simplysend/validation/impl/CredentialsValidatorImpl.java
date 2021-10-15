package com.manning.simplysend.validation.impl;

import com.manning.simplysend.validation.CredentialsValidator;
import com.manning.simplysend.validation.CredentialsValidity;
import org.springframework.stereotype.Component;

@Component
public class CredentialsValidatorImpl implements CredentialsValidator {

    private final String SPECIAL_CHARACTERS = "!@#$%&*()’+,-./:;<=>?[]^_`{|}";

    @Override
    public CredentialsValidity validateUserName(String email) {
        if(!isValidUsernameFormat(email)){
            return CredentialsValidity.NOT_VALID_USERNAME_FORMAT;
        }

        return CredentialsValidity.VALID;
    }

    @Override
    public CredentialsValidity validatePassword(String email) {
        if(!isValidPasswordLength(email)){
            return CredentialsValidity.NOT_VALID_PASSWORD_LENGTH;
        } else if(!isValidPasswordCharacters(email)){
            return CredentialsValidity.NOT_VALID_PASSWORD_CHARACTERS;
        }

        return CredentialsValidity.VALID;
    }

    private boolean isValidUsernameFormat(String email){
        final int atIndex = email.indexOf('@');
        return 0 < atIndex && atIndex < (email.length() - 1);
    }

    private boolean isValidPasswordLength(String email){
        return 8 <= email.length() && email.length() <= 16;
    }

    private boolean isValidPasswordCharacters(String email){

        if(email.chars().mapToObj(c -> Character.toString((char) c)).noneMatch(SPECIAL_CHARACTERS::contains)){
            return false;
        }

        if(email.chars().mapToObj(c -> (char) c).noneMatch(Character::isDigit)){
            return false;
        }

        if(email.chars().mapToObj(c -> (char) c).noneMatch(Character::isUpperCase)){
            return false;
        }

        return true;
    }
}
