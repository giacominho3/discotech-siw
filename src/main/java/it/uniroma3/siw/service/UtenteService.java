package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository ur;
	
	@Transactional
	public Utente findById (Long id) {
		return this.ur.findById(id).get();
	}
	
	@Transactional
	public Utente salva (Utente u) {
		return this.ur.save(u);
	}
	@Transactional
	public void cancella (Utente u) {
		this.ur.delete(u);
	}
	
	@Transactional
	public void cancellaTutti () {
		this.ur.deleteAll();
	}
	
	@Transactional
	public Long conta () {
		return this.ur.count();
	}
	@Transactional
	public List<Utente> getAllUtenti() {
		return (List<Utente>) this.ur.findAll();
	}

}
