package org.sid.cinema.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Film {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	private String titre ;
	private String description;
	private String realisateur ;
	private Date dateSortie;
	private String annonce;
	@Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "hh:mm:ss")
	private Date  duree ;
	private String photo ;
	@OneToMany ( mappedBy = "film")
	@JsonIgnore
	private Collection<ProjectionFilm> projectionFilms ;
	@ManyToOne
	private Categorie categorie ;
	@OneToMany (mappedBy = "film")
	@JsonIgnore
	private Collection<Affiche> affiches ;
	 
	public String copy(String image) {
		String[] array=image.split("\\\\");
		return (array[2]);
	}
}
