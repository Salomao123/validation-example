package com.example.validation_request.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.validation_request.validation.validator.InputRequestValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = InputRequestValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInputRequest {
    String message () default "Validação do input request falhou";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
