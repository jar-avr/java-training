package com.training.constraint;

import com.training.dto.InspectorRegistrationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        InspectorRegistrationDto user = (InspectorRegistrationDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
