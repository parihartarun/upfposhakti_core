package com.upfpo.app.custom.annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = MobileNumberValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {
	
	public  String message() default "Please enter 10 digit mobile number";
	public  Class<?>[] groups() default {};
    public  Class<? extends Payload>[] payload() default {};


}
