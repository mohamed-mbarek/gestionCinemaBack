package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.Affiche;
import org.sid.cinema.repository.AfficheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfficheService {

	private final AfficheRepository afficheRepository;
	@Autowired
	public AfficheService(AfficheRepository afficheRepository) {
		this.afficheRepository=afficheRepository;
	}
	
	public Affiche addAffiche(Affiche affiche) {
		String aa=affiche.getImage();
		String bb=affiche.copy(aa);
		affiche.setImage(bb);
		return afficheRepository.save(affiche);
	}
	
	public List<Affiche> findAllAffiche(){
		return afficheRepository.findAll();
	}
	
	public void deleteAffiche(Long id ) {
		afficheRepository.deleteById(id);
	}
	
	public Affiche updateAffiche(Affiche affiche) {
	 int x=affiche.getImage().indexOf("\\");
	 if(x>0) {
			String aa=affiche.getImage();
			String bb=affiche.copy(aa);
			affiche.setImage(bb);
	 }
		return afficheRepository.save(affiche);
	}
	
	public Affiche findAfficheById(Long id) {
		return  afficheRepository.findAfficheById(id) ;
	}
	
}
