package com.mogilan.companymanager.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckEmailDomainNameValidator implements ConstraintValidator<CheckEmailDomainName, String> {
    private String domainName;

    @Override
    public void initialize(CheckEmailDomainName checkEmailDomainName) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
        domainName = checkEmailDomainName.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(domainName);
    }
}
