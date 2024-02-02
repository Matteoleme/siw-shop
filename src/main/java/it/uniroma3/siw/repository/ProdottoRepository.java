package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Prodotto;
import it.uniroma3.siw.model.Produttore;

import java.util.List;
import it.uniroma3.siw.model.Tipologia;



public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {

	public Boolean existsByNome(String nome);
	
	public List<Prodotto> findByProduttore(Produttore produttore);
	
	public List<Prodotto> findByTipologia(Tipologia tipologia);
	
	public List<Prodotto> findByNomeContaining(String keyWord);
	
	//public List<Prodotto> findByPrezzoIsLessThanEqualsList(Float prezzo);
}
