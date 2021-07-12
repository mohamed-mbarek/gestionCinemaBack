package org.sid.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor 
public class Ticket {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String nomClient;
	private double prix ;
	@Column(unique = true)
	private int codePayement ;
	private boolean reserve;
	@ManyToOne
	private Place place ;
	@ManyToOne
	private ProjectionFilm projectionFilm ;
}
