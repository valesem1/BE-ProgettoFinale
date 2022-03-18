package it.epicenergyservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicenergyservices.model.StatoFattura;
import it.epicenergyservices.repository.StatoFatturaRepository;

@Service
public class StatoFatturaService {

	@Autowired
	StatoFatturaRepository statoFattura;

	public void save(StatoFattura c) {
		statoFattura.save(c);
	}

	public void deleteById(Long id) {
		statoFattura.deleteById(id);
	}

	public StatoFattura getById(Long id) {
		return statoFattura.getById(id);
	}

	public void update(Long id, StatoFattura stato) {
		StatoFattura ce = statoFattura.getById(id);
		ce.setNome(stato.getNome());
		statoFattura.save(ce);
	}
}
