package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Produttore;
import java.util.List;
import it.uniroma3.siw.model.Prodotto;



public interface ProduttoreRepository extends CrudRepository<Produttore, Long> {

	public String findByNome(String nome);
	
	@Query("SELECT prod FROM Produttore prod JOIN prod.prodotti p WHERE p IN :prodotti")
	public List<Produttore> findByProdotti(@Param("prodotti") List<Prodotto> prodotti);

}
