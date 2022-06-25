package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	AutoreRepository autoreRepo;
	
	@Transactional
	public Autore salva (Autore a) {
		return this.autoreRepo.save(a);
	}
	
	@Transactional
	public void cancella (Autore a) {
		this.autoreRepo.delete(a);
	}
	
	@Transactional
	public void cancellaTutti () {
		this.autoreRepo.deleteAll();
	}
	
	@Transactional
	public Long conta () {
		return this.autoreRepo.count();
	}
	
	@Transactional
	public Autore cercaCognome (String cognome) {
		return this.autoreRepo.findByCognome(cognome);
	}
	
	@Transactional
	public List<Autore> cercaNomeOrCognome (String nome, String cognome) {
		if (nome != null || cognome != null) {
			return this.autoreRepo.findByNomeOrCognome(nome, cognome);
		}
		else {
			return (List<Autore>) this.autoreRepo.findAll();
		}
	}
	
	@Transactional
	public Autore cercaNomeCognome (String nome, String cognome) {
		return this.autoreRepo.findByNomeAndCognome(nome, cognome);
	}
	
	@Transactional
	public Autore cercaId (Long id) {
		return this.autoreRepo.findById(id).get();
	}
	
	@Transactional
	public List<Autore> cercaNazionalità (String nazionalità) {
		return this.autoreRepo.findByNazionalita(nazionalità);
	}
	
	@Transactional
	public List<Autore> listaAutori () {
		return (List<Autore>) this.autoreRepo.findAll();
	}
	
	
	@Transactional 
	public List<Autore> listaPerCognomeAsc () {
		return (List<Autore>)this.autoreRepo.findAllByOrderByCognomeAsc();
	}
	  
	@Transactional 
	public List<Autore> listaPerCognomeDesc () { 
		return (List<Autore>)this.autoreRepo.findAllByOrderByCognomeDesc();
	}
	
	@Transactional
	public List<Autore> listaPerNazionalitaAsc () {
		return (List<Autore>)this.autoreRepo.findAllByOrderByNazionalitaAsc();
	}
	
	@Transactional
	public List<Autore> listaPerNazionalitaDesc () {
		return (List<Autore>)this.autoreRepo.findAllByOrderByNazionalitaDesc();
	}
	
	public List<Autore> findAllAutore() {
		List<Autore> tuttiAutori = new ArrayList<Autore>();

		for (Autore c : autoreRepo.findAll()) {
			tuttiAutori.add(c);
		}

		return tuttiAutori;
	}
}
