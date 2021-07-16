package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.exception.VilleNotFoundException;
import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.Ville;
import org.sid.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CinemaService {
	
	private final CinemaRepository cinemaRepository ;
	

	@Autowired
	public CinemaService(CinemaRepository repository) {
		cinemaRepository=repository;
	}
	
	public Cinema addCinema(Cinema cinema) {
		String aa=cinema.getImage();
		String bb=cinema.copy(aa);
		cinema.setImage(bb);
		return cinemaRepository.save(cinema);
	}
	
	public List<Cinema> findAllCinema(){
		return cinemaRepository.findAll();
	}
	
	public void deleteCinema(Long id ) {
		cinemaRepository.deleteById(id);
	}
	
	public Cinema updateCinema(Cinema cinema) {
		return cinemaRepository.save(cinema);
	}
	
	public Cinema findCinemaById(Long id) {
		return  cinemaRepository.findById(id).orElseThrow(() -> new VilleNotFoundException(" aucun cinema trouver 0 ") );
	}
	
	
}
