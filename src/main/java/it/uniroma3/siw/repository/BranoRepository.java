package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.Brano;

public interface BranoRepository extends CrudRepository<Brano, Long> {
	
	public List<Brano> findByNome(String nome);
	public List<Brano> findByAutore(Autore autore);
	public List<Brano> findByGenere(String genere);
	public List<Brano> findAllByOrderByNomeAsc();
	public List<Brano> findAllByOrderByNomeDesc();
	public List<Brano> findAllByOrderByDataAsc();
	public List<Brano> findAllByOrderByDataDesc();
}
