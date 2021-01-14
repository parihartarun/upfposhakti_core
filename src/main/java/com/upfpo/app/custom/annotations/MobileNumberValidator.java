package com.upfpo.app.custom.annotations;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<Mobile, Long>{

	@Override
	public void initialize(Mobile arg0) {
	}

	@Override
	public boolean isValid(Long contactField, ConstraintValidatorContext cxt) {
		return contactField != null && contactField.toString().matches("[0-9]+") 
        && contactField.toString().length()<11 && contactField.toString().length()>9 ;
	}	
	}