package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Credenziali;

@Repository
public interface CredenzialiRepository extends CrudRepository<Credenziali, Long> {

	 Credenziali findByEmail(String email);
}
