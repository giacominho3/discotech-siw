package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long> {
	
	public List<Autore> findByCognome(String cognome);
	public Autore findByNomeAndCognome(String nome, String cognome);
	public List<Autore> findByNomeOrCognome(String nome, String cognome);
	public List<Autore> findByNazionalita(String nazionalità);
	public List<Autore> findAllByOrderByCognomeAsc();
	public List<Autore> findAllByOrderByCognomeDesc();
	public List<Autore> findAllByOrderByDataNascitaAsc();
	public List<Autore> findAllByOrderByDataNascitaDesc();
}
