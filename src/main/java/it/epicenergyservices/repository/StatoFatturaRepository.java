package it.epicenergyservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import it.epicenergyservices.model.StatoFattura;

@Component
public interface StatoFatturaRepository extends JpaRepository<StatoFattura, Long> {

	public StatoFattura getById(Long id);
	
	public StatoFattura getByNome(String nome);
	
}
