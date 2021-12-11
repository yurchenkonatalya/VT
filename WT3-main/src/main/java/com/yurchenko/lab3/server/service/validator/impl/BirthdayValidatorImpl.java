package com.labovichl.lab3.server.service.validator.impl;

import com.labovichl.lab3.server.service.validator.AbstractValidator;

public class BirthdayValidatorImpl extends AbstractValidator {
    private static final String BIRTHDAY_REGEX = "";

    @Override
    protected String getRegex() {
        return BIRTHDAY_REGEX;
    }
}
