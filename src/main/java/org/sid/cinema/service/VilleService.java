package org.sid.cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.sid.cinema.exception.VilleNotFoundException;
import org.sid.cinema.model.Ville;
import org.sid.cinema.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleService {

	private final VilleRepository villeRepository;

	@Autowired
	public VilleService(VilleRepository villeRepository) {
		this.villeRepository = villeRepository;
	}
	
	
	public Ville addVille(Ville ville) {
		String aa=ville.getImage();
		String bb=ville.copy(aa);
		ville.setImage(bb);
		return villeRepository.save(ville);
	}
	
	public List<Ville> findAllVille(){
		return villeRepository.findAll();
	}
	
	public void deleteVille(Long id ) {
		villeRepository.deleteById(id);
	}
	
	public Ville updateVille(Ville ville) {
		return villeRepository.save(ville);
	}
	
	public Ville findVilleById(Long id) {
		return  villeRepository.findVilleById(id).orElseThrow(() -> new VilleNotFoundException("Ville by id ") );
	}
	
	
}
