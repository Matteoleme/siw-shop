package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Prodotto;
import java.util.List;
import java.util.Optional;
import it.uniroma3.siw.model.Utente;


public interface RecensioneRepository extends CrudRepository<Recensione, Long> {

	public boolean existsByProdottoAndUtente(Prodotto prodotto, Utente utente);
	
	public List<Recensione> findByProdotto(Prodotto prodotto);

	@Query("SELECT AVG(r.valutazione) FROM Recensione r WHERE r.prodotto.id = :idProdotto")
	Optional<Double> findMediaRecensioniByProdottoId(@Param("idProdotto") Long idProdotto);

}
