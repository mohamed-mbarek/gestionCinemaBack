package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Seance;
import org.sid.cinema.service.SeanceService;
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
@RequestMapping("/seances")
public class SeanceController {
	@Autowired
	private final SeanceService seanceService ;
	
	public SeanceController(SeanceService service) {
		this.seanceService=service;
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<Seance>> getAllSeances () {
	        List<Seance> Seances = seanceService.findAllSeance();
	        return new ResponseEntity<>(Seances, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Seance> getSeanceById (@PathVariable("id") Long id) {
	        Seance Seance = seanceService.findSeanceById(id);
	        return new ResponseEntity<>(Seance, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Seance> addSeance(@RequestBody Seance Seance) {
	        Seance newSeance = seanceService.addSeance(Seance);
	        return new ResponseEntity<>(newSeance, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Seance> updateSeance(@RequestBody Seance Seance) throws ParseException {
	    	Seance updateSeance = seanceService.updateSeance(Seance);
	        return new ResponseEntity<>(updateSeance, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        seanceService.deleteSeance(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
}
