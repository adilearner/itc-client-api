package com.itc.clientapi.clientApi.custom_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueClientIdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueClientId {
	
    String message() default "Client with Id is already registered";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
}
