package it.uniroma3.siw.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import it.uniroma3.siw.dto.CredenzialiRegistrationDto;
import it.uniroma3.siw.model.Credenziali;

public interface CredenzialiService extends UserDetailsService{
	Credenziali save(CredenzialiRegistrationDto registrationDto);
}
