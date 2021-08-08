package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.Reclamation;
import org.sid.cinema.model.Salle;
import org.sid.cinema.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReclamationService {

	@Autowired
	public final ReclamationRepository reclamationRepository;
	
	public ReclamationService(ReclamationRepository reclamationRepository) {
		this.reclamationRepository=reclamationRepository;
	}

	public Reclamation addReclamation(Reclamation reclamation) {
		return reclamationRepository.save(reclamation);
	}
	
	public List<Reclamation> findAllReclamation(){
		return reclamationRepository.findAll();
	}
	
	public void deleteReclamation(Long id ) {
		reclamationRepository.deleteById(id);
	}
	public Reclamation updateVu(Reclamation reclamation) {
		reclamation.setVu(true);
		return reclamationRepository.save(reclamation);
	}
	public int nbRecNonVy() {
		return reclamationRepository.findRecNonVu();
	}
}
