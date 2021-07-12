package org.sid.cinema.repository;

import java.util.Optional;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Long> {
	Optional<Ville>  findVilleById(Long id) ;
}
