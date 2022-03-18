package it.epicenergyservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import it.epicenergyservices.model.Indirizzo;

@Component
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long> {

	public Indirizzo getById(Long id);
	public Indirizzo getByVia(String via);

}
