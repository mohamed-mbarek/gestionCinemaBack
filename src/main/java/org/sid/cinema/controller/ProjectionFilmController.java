package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.ProjectionFilm;
import org.sid.cinema.service.ProjectionFilmService;
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
@RequestMapping("/projectionFilm")
public class ProjectionFilmController {

	private final ProjectionFilmService filmService;
	
	public ProjectionFilmController(ProjectionFilmService filmService) {
		this.filmService=filmService;
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<ProjectionFilm>> getAllVilles () {
	        List<ProjectionFilm> projections = filmService.findAllProjectionFilm();
	        return new ResponseEntity<>(projections, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<ProjectionFilm> getVilleById (@PathVariable("id") Long id) {
		 ProjectionFilm projectionFilm = filmService.findProjectionFilmById(id);
	        return new ResponseEntity<>(projectionFilm, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<ProjectionFilm> addVille(@RequestBody ProjectionFilm projectionFilm) {
		 ProjectionFilm newProjection = filmService.addProjectionFilmRepository(projectionFilm);
	        return new ResponseEntity<>(newProjection, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<ProjectionFilm> updateVille(@RequestBody ProjectionFilm  projectionFilm) throws ParseException {
		 ProjectionFilm updateProjectionFilm = filmService.updateProjectionFilm(projectionFilm);
	        return new ResponseEntity<>(updateProjectionFilm, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        filmService.deleteProjectionFilm(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 

}
