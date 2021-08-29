package org.sid.cinema.model;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Commentaire {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(name="date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	@Lob
	private String commentaire ;
	@Column(name = "vu", columnDefinition = "boolean default false")
	private boolean vu=false ;
	@ManyToOne 
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ProjectionFilm projectionFilm ;
	@ManyToOne 
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Admin admin;
}
