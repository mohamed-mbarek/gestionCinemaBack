package org.sid.cinema.repository;


import java.util.List;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle, Long> {

	Salle findSalleById(Long id);

	@Query("select s from Salle s  where s.cinema.id= ?1")
	List<Salle> findByCinema (Long  id);
}
