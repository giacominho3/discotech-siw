package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
	
	public List<Utente> findByNome(String nome);

	public boolean existsByNomeAndCognome(String nome, String cognome);
}
