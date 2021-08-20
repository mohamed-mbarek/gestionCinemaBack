package org.sid.cinema.model;

import java.io.Serializable;
import java.util.Collection;

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
public class Place {
	
	@Id  @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ; 
	private int numeroPlace;
	@ManyToOne
	private Salle salle;
}
