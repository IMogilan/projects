package com.mogilan.companymanager.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.mogilan.companymanager.util.CompanyInfoUtil.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailDomainNameValidator.class)
public @interface CheckEmailDomainName {

    public String value() default COMPANY_DOMAIN_NAME;
    public String message() default "You should entered work email with domain name \"@" + COMPANY_DOMAIN_NAME + "\"";

    public Class<?> [] groups() default {};
    public Class<? extends Payload> [] payload() default {};
}
