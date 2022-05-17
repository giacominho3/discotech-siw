package it.uniroma3.siw.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.repository.CredenzialiRepository;

@Service
public class CredenzialiService {
	
	@Autowired
	CredenzialiRepository cr;
	
	@Transactional
	public Credenziali getCredenziali(Long id) {
		return this.cr.findById(id).get();
	}
	
	@Transactional
	public Credenziali getCredenziali(String username) {
		return this.cr.findByUsername(username).get();
	}
	
	@Transactional
	public Credenziali saveCredenziali(Credenziali c) {
		return this.cr.save(c);
	}

}
