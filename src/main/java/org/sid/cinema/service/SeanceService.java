package org.sid.cinema.service;


import java.util.List;

import org.sid.cinema.model.Seance;
import org.sid.cinema.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeanceService {


	private final SeanceRepository SeanceRepository;

	@Autowired
	public SeanceService(SeanceRepository SeanceRepository) {
		this.SeanceRepository = SeanceRepository;
	}
	
	
	public Seance addSeance(Seance Seance) {
			return SeanceRepository.save(Seance);
	}
	
	public List<Seance> findAllSeance(){
		return SeanceRepository.findAll();
	}
	
	public void deleteSeance(Long id ) {
		SeanceRepository.deleteById(id);
	}
	
	public Seance updateSeance(Seance Seance) {
		return SeanceRepository.save(Seance);
	}
	
	public Seance findSeanceById(Long id) {
		return  SeanceRepository.findSeanceById(id);
	}
	

}
