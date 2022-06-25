package it.uniroma3.siw.controller.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.service.CredentialsService;


@Component
public class CredentialsValidator implements Validator {

	@Autowired
	private CredentialsService cs;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Credentials.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (this.cs.alreadyExists((Credentials)target)) {
			errors.reject("credenziali.duplicato");
		}
	}
	
}
