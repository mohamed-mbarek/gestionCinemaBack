package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.Commentaire;
import org.sid.cinema.model.Film;
import org.sid.cinema.model.Reclamation;
import org.sid.cinema.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService {
 
	private final CommentaireRepository commentaireRepository;
	@Autowired
	public CommentaireService (CommentaireRepository repository) {
		this.commentaireRepository=repository;
	}
	
	public List<Commentaire> findAllCommentaire(){
		return commentaireRepository.findAll();
	}
	
	public Commentaire addCommentaire(Commentaire commentaire){
		return commentaireRepository.save(commentaire);
	}
	public void deleteCommentaire(Long id ) {
		commentaireRepository.deleteById(id);
	}
	public Commentaire findCommentaireById(Long id) {
		return commentaireRepository.findCommentaireById(id);
	}
	public List<Commentaire>findCommentaireByProjection(Long id) {
		return commentaireRepository.findCommentaire(id);
	}
	public int nbRecNonVy() {
		return commentaireRepository.findCmntNonVu();
	}
	
	public Commentaire updateVu(Commentaire commentaire) {
		commentaire.setVu(true);
		return commentaireRepository.save(commentaire);
	}

}
