package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Tipologia;
import java.util.List;


public interface TipologiaRepository extends CrudRepository<Tipologia, Long> {

	public List<Tipologia> findByNome(String nome);
}
