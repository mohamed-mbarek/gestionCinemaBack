package org.sid.cinema.repository;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.Film;
import org.sid.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance, Long> {
	Seance findSeanceById(Long id);

}
