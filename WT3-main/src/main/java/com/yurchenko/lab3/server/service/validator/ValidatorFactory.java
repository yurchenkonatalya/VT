package com.labovichl.lab3.server.service.validator;

import com.labovichl.lab3.server.service.validator.impl.*;

public class ValidatorFactory {

    private final Validator bithdayValidator=new BirthdayValidatorImpl();
    private final Validator gradeBookValidator=new GradeBookValidatorImpl();
    private final Validator loginPasswordValidator=new LoginPasswordValidatorImpl();
    private final Validator studentInfoValidator=new StudentInfoValidatorImpl();
    private final Validator updateStudentInfoValidator=new UpdateStudentInfoValidatorImpl();



    public Validator getBithdayValidator() {
        return bithdayValidator;
    }

    public Validator getGradeBookValidator() {
        return gradeBookValidator;
    }

    public Validator getStudentInfoValidator() {
        return studentInfoValidator;
    }

    public Validator getUpdateStudentInfoValidator() {
        return updateStudentInfoValidator;
    }

    public Validator getLoginPasswordValidator() {
        return loginPasswordValidator;
    }

    public static ValidatorFactory getInstance() {
        return Holder.INSTANCE;
    }

    private ValidatorFactory() {
    }

    private static class Holder {
        static final ValidatorFactory INSTANCE = new ValidatorFactory();
    }
}
