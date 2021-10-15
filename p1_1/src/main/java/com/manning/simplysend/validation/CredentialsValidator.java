package com.manning.simplysend.validation;

public interface CredentialsValidator {
    CredentialsValidity validateUserName(String email);
    CredentialsValidity validatePassword(String email);
}
