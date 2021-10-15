package com.manning.simplysend.validation;

public enum CredentialsValidity {
    VALID,
    NOT_VALID_PASSWORD_LENGTH,
    NOT_VALID_PASSWORD_CHARACTERS,
    NOT_VALID_USERNAME_FORMAT,
    NOT_VALID_USERNAME_ALREADY_EXISTS,
}
