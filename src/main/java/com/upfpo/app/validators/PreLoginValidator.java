package com.upfpo.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.upfpo.app.entity.Users;
import com.upfpo.app.util.PasswordReset;

@Component
public class PreLoginValidator implements Validator{
	
	//private static final Logger logger = Logger.getLogger(RegistrationValidator.class);
	

	@Override
	public boolean supports(Class<?> classname) {

		if(classname==Users.class)
		{
			return 	Users.class.isAssignableFrom(classname);
		}

		if(classname==PasswordReset.class)
		{
			return 	PasswordReset.class.isAssignableFrom(classname);
		}
		
		return 	classname.getClass().isAssignableFrom(classname);
}
	
	@Override
	public void validate(Object obj, Errors errors) {
		
		
		
		if(obj.getClass()==PasswordReset.class)
		{
			PasswordReset users = (PasswordReset) obj;
			ValidationUtils.rejectIfEmpty(errors, "userName","login.user.empty");
			ValidationUtils.rejectIfEmpty(errors, "mobNo", "pass.reset.mobile");
		}
		
		if(obj.getClass()==Users.class)
		{
			Users users = (Users) obj;
			ValidationUtils.rejectIfEmpty(errors, "userName","login.user.empty");
			ValidationUtils.rejectIfEmpty(errors, "password", "login.pass.empty");
			ValidationUtils.rejectIfEmpty(errors, "captcha", "login.captch.empty");
		}
	}
	
}

