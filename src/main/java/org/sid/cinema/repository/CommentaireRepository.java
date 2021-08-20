package org.sid.cinema.repository;

import java.util.List;

import org.sid.cinema.model.Commentaire;
import org.sid.cinema.model.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	Commentaire findCommentaireById(Long id);
	
	@Query("select	c from Commentaire c   where c.projectionFilm.id=?1")
	List<Commentaire> findCommentaire (Long id);
	
	@Query("select count(id) from Commentaire c   where vu='false'")
	int findCmntNonVu ();

}
