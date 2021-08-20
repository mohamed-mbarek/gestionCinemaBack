package org.sid.cinema.repository;

import java.util.List;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionFilmRepository extends JpaRepository<ProjectionFilm, Long> {

	ProjectionFilm findProjectionFilmById(Long id);
	
	@Query("select p from ProjectionFilm p ,Salle s  where p.salle.id=s.id and s.cinema.id=?1")
	List<ProjectionFilm> findFilmByCinema (Long  id);

}
