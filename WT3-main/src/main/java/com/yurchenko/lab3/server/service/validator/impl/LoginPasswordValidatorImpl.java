package com.labovichl.lab3.server.service.validator.impl;

import com.labovichl.lab3.server.service.validator.AbstractValidator;

public class LoginPasswordValidatorImpl extends AbstractValidator {
    private static final String LOGIN_PASSWORD_REGEX = "^[^:]+:[^:]+$";

    @Override
    protected String getRegex() {
        return LOGIN_PASSWORD_REGEX;
    }
}