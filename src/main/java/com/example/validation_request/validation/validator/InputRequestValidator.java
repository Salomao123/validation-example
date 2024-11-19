package com.example.validation_request.validation.validator;

import org.springframework.util.StringUtils;

import com.example.validation_request.dto.request.InputRequestDTO;
import com.example.validation_request.validation.ValidInputRequest;

import ch.qos.logback.core.util.StringUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class InputRequestValidator implements ConstraintValidator<ValidInputRequest, InputRequestDTO>{

    @Override
    public boolean isValid(InputRequestDTO dto, ConstraintValidatorContext context) {
       boolean hasValidField = StringUtils.hasText(dto.getNome()) ||
                                StringUtils.hasText(dto.getSobrenome()) ||
                                StringUtils.hasText(dto.getEmail());

        if (hasValidField){
                    return true;
        }

        

        if (!hasValidField) {
            
            boolean hasAtLeastOneField = StringUtils.hasText(dto.getNome()) ||
                                         StringUtils.hasText(dto.getSobrenome()) && (StringUtil.isNullOrEmpty(dto.getEmail()));

            if (hasAtLeastOneField) {
                return true;
            }

            boolean hasAtLeastEmail = StringUtils.hasText(dto.getEmail()) &&
            (StringUtil.isNullOrEmpty(dto.getNome()) || StringUtil.isNullOrEmpty(dto.getSobrenome()));

            if (hasAtLeastEmail) {
                return true;
            }

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Pelo menos um campo deve ser preenchido")
                    .addConstraintViolation();
                    return false;
        }
        
       return true;
    }
    
}
