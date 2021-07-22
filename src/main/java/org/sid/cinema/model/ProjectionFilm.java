package org.sid.cinema.model;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data  @AllArgsConstructor @NoArgsConstructor @ToString
public class ProjectionFilm {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long id ; 
	 private Date dateProjection ;
	 private double prix ;
	 @ManyToOne
	 private Salle salle; 
	 @ManyToOne 
	 private Film film ;
	 @OneToMany (mappedBy = "projectionFilm")
	 @JsonIgnore
	 private Collection<Ticket>tickets;
	 @ManyToOne
	 private  Seance seance ;
}
