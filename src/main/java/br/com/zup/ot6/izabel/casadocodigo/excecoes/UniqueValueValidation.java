package br.com.zup.ot6.izabel.casadocodigo.excecoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidation implements ConstraintValidator<UniqueValue, Object>{

	private String domainAttribute;
	private Class<?> klass;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void initialize(UniqueValue uniqueValue) {
		domainAttribute = uniqueValue.fieldName();
        klass = uniqueValue.domainClass();
        
    }
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		Query query = entityManager.createQuery("select 1 from " + klass.getName() + 
				" where " + domainAttribute + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		
		Assert.state(list.size() <= 1, "Foi encontrada mais de um " + klass + "com o atributo"
				+ domainAttribute + ": " + value);
		
		return list.isEmpty();
	}

}
