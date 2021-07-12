package org.sid.cinema.model;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor 
public class Salle {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	private String nom ;
	private int nombrePlace ;
	@ManyToOne
	private Cinema cinema;
	@OneToMany (mappedBy = "salle")
	private Collection<Place> places ;
	@OneToMany (mappedBy = "salle")
	private Collection<ProjectionFilm>projectionFilms;
	
}
