package com.upfpo.app.custom.annotations;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LandLineValidator implements ConstraintValidator<LandLine, Long>{

	@Override
	public void initialize(LandLine arg0) {
	}
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
	 @Override
	    public boolean isValid(Long contactField,
	      ConstraintValidatorContext cxt) {
	        return contactField != null && contactField.toString().matches("[0-9]+") 
	        		&& (contactField.toString().length() > 8) && (contactField.toString().length() < 14);
	    }
}
