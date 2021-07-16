package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Salle;
import org.sid.cinema.service.SalleService;
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
@RequestMapping("/salles")
public class SalleController {
	
	@Autowired
	private final SalleService salleService;
	
	public SalleController(SalleService salleService) {
		this.salleService=salleService;
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<Salle>> getAllSalles () {
	        List<Salle> salles =salleService.findAllSalle();
	        return new ResponseEntity<>(salles, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Salle> getSalleById (@PathVariable("id") Long id) {
	        Salle Salle = salleService.findSalleById(id);
	        return new ResponseEntity<>(Salle, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle) {
	        Salle newSalle = salleService.addSalle(salle);
	        return new ResponseEntity<>(newSalle, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Salle> updateSalle(@RequestBody Salle salle) throws ParseException {
	    	Salle updateSalle = salleService.updateSalle(salle);
	        return new ResponseEntity<>(updateSalle, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        salleService.deleteSalle(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    @GetMapping("/getSalle/{id}")
	    public ResponseEntity<List<Salle>> getAllSalleeByIdCinema (@PathVariable("id") Long id) {
	        List<Salle> salles = salleService.findAllSalleCinema(id);
	        return new ResponseEntity<>(salles, HttpStatus.OK);
	    }
	    
	
}
