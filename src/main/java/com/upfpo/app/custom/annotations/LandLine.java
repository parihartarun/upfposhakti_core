package com.upfpo.app.custom.annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = LandLineValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LandLine {
	
	public  String message() default "Please enter valid landline number";
	public  Class<?>[] groups() default {};
    public  Class<? extends Payload>[] payload() default {};

}
