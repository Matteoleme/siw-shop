package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Tipologia;
import java.util.List;
import it.uniroma3.siw.model.Prodotto;



public interface TipologiaRepository extends CrudRepository<Tipologia, Long> {

	public String findByNome(String nome);
	
	@Query("SELECT t FROM Tipologia t JOIN t.prodotti p WHERE p IN :prodotti")
	public List<Tipologia> findByProdotti(@Param("prodotti") List<Prodotto> prodotti);

}
