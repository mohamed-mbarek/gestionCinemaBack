package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.ProjectionFilm;
import org.sid.cinema.repository.ProjectionFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionFilmService {
	@Autowired
	private final ProjectionFilmRepository projectionFilmRepository;

	public ProjectionFilmService (ProjectionFilmRepository projectionFilmRepository) {
		this.projectionFilmRepository=projectionFilmRepository;
	}
	

	public ProjectionFilm addProjectionFilmRepository(ProjectionFilm projectionFilm) {
		return projectionFilmRepository.save(projectionFilm);
	}
	
	public List<ProjectionFilm> findAllProjectionFilm(){
		return projectionFilmRepository.findAll();
	}
	
	public void deleteProjectionFilm(Long id ) {
		projectionFilmRepository.deleteById(id);
	}
	
	public ProjectionFilm updateProjectionFilm(ProjectionFilm projectionFilm) {
		return projectionFilmRepository.save(projectionFilm);
	}
	
	public ProjectionFilm findProjectionFilmById(Long id) {
		return  projectionFilmRepository.findProjectionFilmById(id);
	}
	
	
}
