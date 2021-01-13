package com.upfpo.app.custom.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<UserName, String>{

	 @Override
	    public void initialize(UserName username) {
	    }

	 @Override
	    public boolean isValid(String contactField,
	      ConstraintValidatorContext cxt) {
	        return contactField != null && contactField.matches("^[a-z0-9_]*$")
	          && (contactField.length() > 8) && (contactField.length() < 26);
	    }
}
