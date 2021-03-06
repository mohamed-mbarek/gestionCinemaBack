package org.sid.cinema.model;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Seance {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	@Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "hh:mm:ss")
	private Date heureDebut ;
	@OneToMany (mappedBy = "seance",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<ProjectionFilm> projectionFilms ;
}
 