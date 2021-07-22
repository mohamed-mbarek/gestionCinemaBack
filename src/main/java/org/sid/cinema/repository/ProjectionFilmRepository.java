package org.sid.cinema.repository;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionFilmRepository extends JpaRepository<ProjectionFilm, Long> {

	ProjectionFilm findProjectionFilmById(Long id);
}
