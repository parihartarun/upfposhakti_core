package com.upfpo.app.custom.annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UserNameValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserName {
	
	public  String message() default "Username should only be a-z & 0-9_";
	public  Class<?>[] groups() default {};
    public  Class<? extends Payload>[] payload() default {};

}
