package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Affiche;
import org.sid.cinema.service.AfficheService;
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
@RequestMapping("/affiches")
public class AfficheController {
	@Autowired
	private final AfficheService afficheService;
	
	public AfficheController(AfficheService afficheService) {
		this.afficheService=afficheService;
	}
	

	 @GetMapping("/all")
	    public ResponseEntity<List<Affiche>> getAllAffiches () {
	        List<Affiche> Affiches = afficheService.findAllAffiche();
	        return new ResponseEntity<>(Affiches, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Affiche> getAfficheById (@PathVariable("id") Long id) {
	        Affiche Affiche = afficheService.findAfficheById(id);
	        return new ResponseEntity<>(Affiche, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Affiche> addAffiche(@RequestBody Affiche Affiche) {
	        Affiche newAffiche = afficheService.addAffiche(Affiche);
	        return new ResponseEntity<>(newAffiche, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Affiche> updateAffiche(@RequestBody Affiche Affiche) throws ParseException {
	    	Affiche updateAffiche = afficheService.updateAffiche(Affiche);
	        return new ResponseEntity<>(updateAffiche, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        afficheService.deleteAffiche(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 

	
}
