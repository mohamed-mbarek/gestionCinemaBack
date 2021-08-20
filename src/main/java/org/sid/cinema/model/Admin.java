package org.sid.cinema.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Admin {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String nom ;
	private String prenom ;
	private String image;
	private String email;
	private String password ;
	private String roles ;
	@OneToMany (mappedBy = "admin")
	@JsonIgnore
	private Collection<Ticket> tickets ;
	@OneToMany (mappedBy = "admin")
	@JsonIgnore
	private Collection<Commentaire> commentaires ;
	
	public String copy(String image) {
		String[] array=image.split("\\\\");
		return (array[2]);
	}
	
}
