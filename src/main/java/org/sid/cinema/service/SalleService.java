package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.Salle;
import org.sid.cinema.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;



@Service
public class SalleService {
	@Autowired
	private final SalleRepository salleRepository;

	public SalleService(SalleRepository repository) {
		this.salleRepository=repository;
	}
	
	
	public Salle addSalle(Salle salle) {
		return salleRepository.save(salle);
	}
	
	public List<Salle> findAllSalle(){
		return salleRepository.findAll();
	}
	
	public void deleteSalle(Long id ) {
		salleRepository.deleteById(id);
	}
	
	public Salle updateSalle(Salle Salle) {
		return salleRepository.save(Salle);
	}
	
	public Salle findSalleById(Long id) {
		return  salleRepository.findSalleById(id);
	}
	
	public List<Salle> findAllSalleCinema(Long  id) {
		return  salleRepository.findByCinema(id);
	}
}
