package org.sid.cinema.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
public class Ticket {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private int nombre ;
	@Column(unique = true)
	private String codePayement ;
	@Column(name="dateReservation", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ProjectionFilm projection ;
	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Admin admin;
	@Column(name = "vu", columnDefinition = "boolean default false")
	private boolean vu=false ;

}
