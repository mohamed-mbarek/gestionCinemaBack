package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Commentaire;
import org.sid.cinema.model.Reclamation;
import org.sid.cinema.model.Ville;
import org.sid.cinema.service.CommentaireService;
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
@RequestMapping("/commentaire")
public class CommentaireComentroller {

	@Autowired
	private final CommentaireService service;

	public CommentaireComentroller(CommentaireService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Commentaire>> getAllCommentaires() {
		List<Commentaire> commentaires = service.findAllCommentaire();
		return new ResponseEntity<>(commentaires, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Commentaire> getCommentaireById(@PathVariable("id") Long id) {
		Commentaire commentaire = service.findCommentaireById(id);
		return new ResponseEntity<>(commentaire, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Commentaire> addCommentaire(@RequestBody Commentaire Commentaire) {
		Commentaire newCommentaire = service.addCommentaire(Commentaire);
		return new ResponseEntity<>(newCommentaire, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Commentaire> updateVille(@RequestBody Commentaire commentaire) {
		Commentaire updateCommentaire = service.updateCommentaire(commentaire);
		return new ResponseEntity<>(updateCommentaire, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCommentaire(@PathVariable("id") Long id) {
		service.deleteCommentaire(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/findCommentaire/{id}")
	public ResponseEntity<List<Commentaire>> getCommentaireByProjectionnId(@PathVariable("id") Long id) {
		List<Commentaire> commentaire = service.findCommentaireByProjection(id);
		return new ResponseEntity<>(commentaire, HttpStatus.OK);
	}

	@GetMapping("/nbRecNonVu")
	public int countNbRecNonVu() {
		return this.service.nbRecNonVy();
	}

	@PutMapping("/updateVu")
	public ResponseEntity<Commentaire> updateVuReclamation(@RequestBody Commentaire commentaire) throws ParseException {
		Commentaire updateCommentaire = service.updateVu(commentaire);
		return new ResponseEntity<>(updateCommentaire, HttpStatus.OK);
	}

}
