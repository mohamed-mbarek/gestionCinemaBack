package org.sid.cinema.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.sid.cinema.model.Ville;
import org.sid.cinema.service.VilleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/villes")
public class VilleController {

	private final VilleService villeService ;
	
	public VilleController(VilleService service) {
		this.villeService=service;
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<Ville>> getAllVilles () {
	        List<Ville> villes = villeService.findAllVille();
	        return new ResponseEntity<>(villes, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Ville> getVilleById (@PathVariable("id") Long id) {
	        Ville ville = villeService.findVilleById(id);
	        return new ResponseEntity<>(ville, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Ville> addVille(@RequestBody Ville ville) {
	        Ville newVille = villeService.addVille(ville);
	        return new ResponseEntity<>(newVille, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Ville> updateVille(@RequestBody Ville ville) throws ParseException {
	    	Ville updateVille = villeService.updateVille(ville);
	        return new ResponseEntity<>(updateVille, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        villeService.deleteVille(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
	 
}
