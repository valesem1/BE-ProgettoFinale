package it.epicenergyservices.util;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicenergyservices.controller.AuthController;
import it.epicenergyservices.controller.ComuneController;
import it.epicenergyservices.controller.ProvinciaController;
import it.epicenergyservices.model.Cliente;
import it.epicenergyservices.model.ERole;
import it.epicenergyservices.model.Fattura;
import it.epicenergyservices.model.Indirizzo;
import it.epicenergyservices.model.Role;
import it.epicenergyservices.model.StatoFattura;
import it.epicenergyservices.model.TipoCliente;
import it.epicenergyservices.repository.ProvinciaRepository;
import it.epicenergyservices.repository.RoleRepository;
import it.epicenergyservices.request.SignupRequest;
import it.epicenergyservices.service.ClienteService;
import it.epicenergyservices.service.ComuneService;
import it.epicenergyservices.service.FatturaService;
import it.epicenergyservices.service.IndirizzoService;
import it.epicenergyservices.service.StatoFatturaService;
import it.epicenergyservices.service.UserService;

@Component
public class PopolaDB implements CommandLineRunner {

	@Autowired
	ClienteService cliente;
	@Autowired
	ComuneService comune;
	@Autowired
	FatturaService fattura;
	@Autowired
	IndirizzoService indirizzo;
	@Autowired
	ProvinciaRepository provincia;
	@Autowired
	StatoFatturaService statoFattura;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserService us;
	@Autowired
	ComuneController cc;
	@Autowired
	ProvinciaController pc;
	@Autowired
	AuthController ac;

	@Override
	public void run(String... args) throws Exception {

		pc.popola();
		cc.popola();

		Role r = new Role(ERole.ROLE_ADMIN);
		Role r1 = new Role(ERole.ROLE_USER);
		roleRepository.save(r);
		roleRepository.save(r1);
		Set<String> roles = new HashSet<String>();
		roles.add("ROLE_ADMIN");
		ac.registerUser(new SignupRequest("admin", "admin@gmail.com", roles, "admin", "admin", "admin"));

		Indirizzo i1 = new Indirizzo("Via Vulcano", 29, 98134, "Periferia", comune.getByNome("Napoli"));
		Indirizzo i2 = new Indirizzo("Via Fasulla", 28, 98345, "Periferia", comune.getByNome("Lecce"));
		Indirizzo i3 = new Indirizzo("Via Nuova", 19, 95682, "Periferia", comune.getByNome("Cisternino"));
		Indirizzo i4 = new Indirizzo("Via Martina Franca", 17, 87233, "Centro", comune.getByNome("Locorotondo"));
		Indirizzo i5 = new Indirizzo("Via Barese", 110, 20050, "Periferia", comune.getByNome("Bari"));
		Indirizzo i6 = new Indirizzo("Via Duomo", 135, 57020, "Centro", comune.getByNome("Como"));
		Indirizzo i7 = new Indirizzo("Via Leonardo Da Vinci", 37, 89010, "Marittima", comune.getByNome("Firenze"));
		Indirizzo i8 = new Indirizzo("Via Roma", 156, 20012, "Centro", comune.getByNome("Taranto"));
		Indirizzo i9 = new Indirizzo("Via Croce", 176, 19070, "Centro", comune.getByNome(" Fasano"));
		Indirizzo i10 = new Indirizzo("Via Paolo Giovanni  ", 84, 26010, "Periferia",comune.getByNome("Vieste"));
		
		indirizzo.save(i1);
		indirizzo.save(i2);
		indirizzo.save(i3);
		indirizzo.save(i4);
		indirizzo.save(i5);
		indirizzo.save(i6);
		indirizzo.save(i7);
		indirizzo.save(i8);
		indirizzo.save(i9);
		indirizzo.save(i10);
		

		Cliente c1 = new Cliente("Citroen", 2762583, TipoCliente.SPA, "citroen@gmail.com", "citroen@pec.com", 16369,
				"Dario", "Caramia", 37125785, "caramia@gmail.com", i1, i1, LocalDate.of(2008, 11, 02),
				LocalDate.of(2021, 11, 27), 33.000);
		
		Cliente c2 = new Cliente("Ferrari", 4267293, TipoCliente.PA, "ferrari@cavallino.com", "ferrari@pec.com",
				94678, "Enzo", "Ferrari", 3734690, "enzoferrari@gmail.com", i2, i2, LocalDate.of(2011, 12, 17),
				LocalDate.of(2023, 2, 1), 450.000);
		
		Cliente c3 = new Cliente("Ford", 2762583, TipoCliente.SRL, "Ford@gmail.com", "Ford@pec.com", 35965, "Henry",
				"Ford", 337125785, "henry@gmail.com", i3, i3, LocalDate.of(2000, 11, 27), LocalDate.of(2020, 6, 7),
				21.000);
		
		Cliente c4 = new Cliente("Roboze", 848724, TipoCliente.SAS, "roboze@gmail.com", "roboze@pec.com", 16369, "Marco",
				"Rossi", 32685543, "marco@roboze.com", i4, i4, LocalDate.of(2009, 2, 12), LocalDate.of(2018, 4, 21),
				500.000);
		
		Cliente c5 = new Cliente("Microsoft", 215789, TipoCliente.SPA, "microsoft@windows.com", "microsoft@pec.com", 74732, "Noemi",
				"Ambra", 38455379, "noemi@microsoft.com", i5, i5, LocalDate.of(2007, 11, 27), LocalDate.of(2015, 11, 27),
				300.0);
		
		Cliente c6 = new Cliente("Asus", 1578904, TipoCliente.PA, "francesco@asus.com", "francesco@pec.com",
				43226, "Francesco", "Caramia", 39583829, "francesco@asus.com", i6, i6, LocalDate.of(2004, 3, 25),
				LocalDate.of(2014, 4, 21), 150.000);
		
		Cliente c7 = new Cliente("", 824689, TipoCliente.SRL, "peppe@gmail.com", "peppe@pec.com", 84335, "Peppe",
				"Bianco", 6327884, "peppe@gmail.com", i7, i7, LocalDate.of(2002, 6, 17), LocalDate.of(2006, 1, 3),
				67.000);
		
		Cliente c8 = new Cliente("Fiat", 173577, TipoCliente.SAS, "fiat@gstellantis.com", "fiat@pec.com", 24789,
				"Vanessa", "Nardelli", 39864357, "vanessa@fiat.com", i8, i8, LocalDate.of(2009, 7, 7),
				LocalDate.of(2016, 11, 27), 10.000);
		
		Cliente c9 = new Cliente("Logitech", 4367843, TipoCliente.PA, "info@logitech.com", "logitech@pec.com", 16369,
				"Mauro", "Viola", 37125785, "mauro@logitech.com", i9, i9, LocalDate.of(2004, 4, 17),
				LocalDate.of(2007, 8, 22), 40.000);
		
		Cliente c10 = new Cliente("Audi", 657853, TipoCliente.PA, "audi@vw.com", "audi@pec.com", 96534,
				"Karl", "Schumacher", 312356906, "karl@audi.com", i10, i10, LocalDate.of(2001, 1, 3),
				LocalDate.of(2009, 12, 23), 70.000);
		
		cliente.save(c1);
		cliente.save(c2);
		cliente.save(c3);
		cliente.save(c4);
		cliente.save(c5);
		cliente.save(c6);
		cliente.save(c7);
		cliente.save(c8);
		cliente.save(c9);
		cliente.save(c10);
	

		StatoFattura s1 = new StatoFattura("Non Pagata");
		StatoFattura s2 = new StatoFattura("Pagata");
		StatoFattura s3 = new StatoFattura("Pagata in ritardo");
		StatoFattura s4 = new StatoFattura("Non Gestita");
		statoFattura.save(s1);
		statoFattura.save(s2);
		statoFattura.save(s3);
		statoFattura.save(s4);

		Fattura f1 = new Fattura(c1, LocalDate.of(2020, 2, 12), 146, 2020, 830.50, s1);
		Fattura f2 = new Fattura(c2, LocalDate.of(2019, 3, 21), 28, 2020, 100.50, s2);
		Fattura f3 = new Fattura(c3, LocalDate.of(2007, 6, 11), 13, 2020, 23.50, s2);
		Fattura f4 = new Fattura(c4, LocalDate.of(2011, 2, 13), 125, 2020, 900.50, s1);
		Fattura f5 = new Fattura(c5, LocalDate.of(2000, 1, 19), 196, 2020, 3356.50, s4);
		Fattura f6 = new Fattura(c6, LocalDate.of(2012, 2, 23), 137, 2020, 8632.50, s3);
		Fattura f7 = new Fattura(c7, LocalDate.of(2015, 9, 17), 104, 2020, 8765.50, s3);
		Fattura f8 = new Fattura(c8, LocalDate.of(2019, 4, 19), 127, 2020, 1358.50, s1);
		Fattura f9 = new Fattura(c9, LocalDate.of(2010, 6, 20), 104, 2020, 8643.50, s1);
		Fattura f10 = new Fattura(c10, LocalDate.of(2019, 11, 21), 134, 2020, 3676.50, s1);
		
		fattura.save(f1);
		fattura.save(f2);
		fattura.save(f3);
		fattura.save(f4);
		fattura.save(f5);
		fattura.save(f6);
		fattura.save(f7);
		fattura.save(f8);
		fattura.save(f9);
		fattura.save(f10);


	}

}
