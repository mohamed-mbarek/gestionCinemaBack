package org.sid.cinema.repository;

import org.sid.cinema.model.Affiche;
import org.sid.cinema.model.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfficheRepository extends JpaRepository<Affiche, Long> {
	Affiche findAfficheById(Long id);

}
