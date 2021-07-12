package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.service.CinemaService;
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
@RequestMapping("/cinemas")
public class CinemaController {

	private final CinemaService cinemaService ;
	
	public CinemaController ( CinemaService service) {
		this.cinemaService=service;
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<Cinema>> getAllCinemas () {
	        List<Cinema> Cinemas = cinemaService.findAllCinema();
	        return new ResponseEntity<>(Cinemas, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Cinema> getCinemaById (@PathVariable("id") Long id) {
	        Cinema Cinema = cinemaService.findCinemaById(id);
	        return new ResponseEntity<>(Cinema, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Cinema> addCinema(@RequestBody Cinema Cinema) {
	        Cinema newCinema = cinemaService.addCinema(Cinema);
	        return new ResponseEntity<>(newCinema, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Cinema> updateCinema(@RequestBody Cinema Cinema) throws ParseException {
	    	Cinema updateCinema = cinemaService.updateCinema(Cinema);
	        return new ResponseEntity<>(updateCinema, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        cinemaService.deleteCinema(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
	 
	
}	
