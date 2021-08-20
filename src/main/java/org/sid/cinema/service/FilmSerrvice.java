package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.Film;
import org.sid.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmSerrvice {

	private final FilmRepository filmRepository;
	
	@Autowired
	public FilmSerrvice(FilmRepository filmRepository) {
		this.filmRepository=filmRepository;
	}
	
	public Film addFilm(Film Film) {
		String aa=Film.getPhoto();
		String bb=Film.copy(aa);
		Film.setPhoto(bb);
		Film.setAnnonce(Film.copy(Film.getAnnonce()));
		return filmRepository.save(Film);
	}
	
	public List<Film> findAllFilm(){
		return filmRepository.findAll();
	}
	
	public void deleteFilm(Long id ) {
		filmRepository.deleteById(id);
	}
	
	public Film updateFilm(Film Film) {
		return filmRepository.save(Film);
	}
	
	public Film findFilmById(Long id) {
		return  filmRepository.findFilmById(id);
	}

}
