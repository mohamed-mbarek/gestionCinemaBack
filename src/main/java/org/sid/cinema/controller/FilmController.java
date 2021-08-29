package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Categorie;
import org.sid.cinema.model.Film;
import org.sid.cinema.service.FilmSerrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/films")
public class FilmController {
	@Autowired
	private final FilmSerrvice filmService;
	
	public FilmController(FilmSerrvice filmSerrvice) {
		this.filmService=filmSerrvice;
	}
	
	

	 @GetMapping("/all")
	    public ResponseEntity<List<Film>> getAllFilms () {
	        List<Film> Films = filmService.findAllFilm();
	        return new ResponseEntity<>(Films, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Film> getFilmById (@PathVariable("id") Long id) {
	        Film Film = filmService.findFilmById(id);
	        return new ResponseEntity<>(Film, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Film> addFilm(@RequestBody Film Film) {
	        Film newFilm = filmService.addFilm(Film);
	        return new ResponseEntity<>(newFilm, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Film> updateFilm(@RequestBody Film Film){
	    	Film updateFilm = filmService.updateFilm(Film);
	        return new ResponseEntity<>(updateFilm, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        filmService.deleteFilm(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 

	
}
