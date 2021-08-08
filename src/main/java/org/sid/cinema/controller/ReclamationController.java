package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Reclamation;
import org.sid.cinema.model.Salle;
import org.sid.cinema.service.ReclamationService;
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
@RequestMapping("/reclamations")
public class ReclamationController {
	
	@Autowired
	private final ReclamationService  reclamationService;
	
	public ReclamationController(ReclamationService reclamationService) {
		this.reclamationService=reclamationService;
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Reclamation>> getAllReclamations () {
        List<Reclamation> Reclamations = reclamationService.findAllReclamation();
        return new ResponseEntity<>(Reclamations, HttpStatus.OK);
    }
	 @PostMapping("/add")
	    public ResponseEntity<Reclamation> addReclamation(@RequestBody Reclamation Reclamation) {
	        Reclamation newReclamation = reclamationService.addReclamation(Reclamation);
	        return new ResponseEntity<>(newReclamation, HttpStatus.CREATED);
	    }
	 
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        reclamationService.deleteReclamation(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
		@PutMapping("/updateVu")
	    public ResponseEntity<Reclamation> updateVuReclamation(@RequestBody Reclamation reclamation) throws ParseException {
	    	Reclamation updateReclamation = reclamationService.updateVu(reclamation);
	        return new ResponseEntity<>(updateReclamation, HttpStatus.OK);
	    }
		@GetMapping("/nbRecNonVu")
		public int  countNbRecNonVu() {
			return  this.reclamationService.nbRecNonVy();
		}
		}

