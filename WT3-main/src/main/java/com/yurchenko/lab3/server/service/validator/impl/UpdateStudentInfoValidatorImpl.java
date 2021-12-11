package com.labovichl.lab3.server.service.validator.impl;

import com.labovichl.lab3.server.service.validator.AbstractValidator;

public class UpdateStudentInfoValidatorImpl extends AbstractValidator {
    private static final String UPDATE_STUDEMT_INFO_REGEX =
            "^((\\d{8}):([^:]+:){3}((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d):([^:]+):(\\d{8}):([^:]+))$";

    @Override
    protected String getRegex() {
        return UPDATE_STUDEMT_INFO_REGEX;
    }
}