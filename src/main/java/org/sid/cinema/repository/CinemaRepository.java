package org.sid.cinema.repository;

import java.util.List;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	@Query("select c from Cinema c where c.ville.id = ?1")
	List<Cinema> findByCinema (Long  id);
}
