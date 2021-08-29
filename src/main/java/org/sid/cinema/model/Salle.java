package org.sid.cinema.model;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Cinema cinema;
	@OneToMany (mappedBy = "salle",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<Place> places ;
	@OneToMany (mappedBy = "salle" ,cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<ProjectionFilm>projectionFilms;
	
}
