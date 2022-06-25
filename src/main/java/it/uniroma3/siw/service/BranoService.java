package it.uniroma3.siw.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.Brano;
import it.uniroma3.siw.repository.BranoRepository;

@Service
public class BranoService {
	
	@Autowired
	BranoRepository branoRepo;

	@Transactional
	public Brano salva(Brano b) {
		return this.branoRepo.save(b);
	}

	@Transactional
	public void cancella(Brano b) {
		this.branoRepo.delete(b);
	}

	@Transactional
	public void cancellaTutti() {
		this.branoRepo.deleteAll();
	}

	@Transactional
	public Long conta() {
		return this.branoRepo.count();
	}

	@Transactional
	public List<Brano> listaBrani() {
		return (List<Brano>) this.branoRepo.findAll();
	}

	@Transactional
	public List<Brano> cercaNome(String nome) {
		return this.branoRepo.findByNome(nome);
	}

	@Transactional
	public Brano cercaId(Long id) {
		return this.branoRepo.findById(id).get();
	}

	@Transactional
	public List<Brano> cercaAutore(Autore a) {
		return this.branoRepo.findByAutore(a);
	}

	@Transactional
	public List<Brano> cercaGenere(String g) {
		return this.branoRepo.findByGenere(g);
	}

	@Transactional
	public List<Brano> listaBraniPerNomeAsc() {
		return (List<Brano>) this.branoRepo.findAllByOrderByNomeAsc();
	}

	@Transactional
	public List<Brano> listaBraniPerNomeDesc() {
		return (List<Brano>) this.branoRepo.findAllByOrderByNomeDesc();
	}

	@Transactional
	public List<Brano> listaBraniPerDataAsc() {
		return (List<Brano>) this.branoRepo.findAllByOrderByDataAsc();
	}

	@Transactional
	public List<Brano> listaBraniPerDataDesc() {
		return (List<Brano>) this.branoRepo.findAllByOrderByDataDesc();
	}
}
