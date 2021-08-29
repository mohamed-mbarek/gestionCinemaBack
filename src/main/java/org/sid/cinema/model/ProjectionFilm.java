package org.sid.cinema.model;

import java.util.Collection;
import java.util.Date;

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
import lombok.ToString;
@Entity
@Data  @AllArgsConstructor @NoArgsConstructor @ToString
public class ProjectionFilm {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long id ; 
	 private Date dateProjection ;
	 private double prix ;
	 @ManyToOne
     @OnDelete(action = OnDeleteAction.CASCADE)
	 private Salle salle; 
	 @ManyToOne 
     @OnDelete(action = OnDeleteAction.CASCADE)
	 private Film film ;
	 @ManyToOne
     @OnDelete(action = OnDeleteAction.CASCADE)
	 private  Seance seance ;
	 @OneToMany (mappedBy = "projection",cascade = CascadeType.REMOVE)
	 @JsonIgnore
	 private Collection<Ticket>tickets;
	 @OneToMany( mappedBy="projectionFilm",cascade = CascadeType.REMOVE)
	 @JsonIgnore
	 private Collection<Commentaire>commentaires;

}
