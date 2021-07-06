package br.com.zup.ot6.izabel.casadocodigo.excecoes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueValueValidation.class})
public @interface UniqueValue {

	String message() default "Valor duplicado é invalido";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String fieldName();
    
    Class<?> domainClass();
}
