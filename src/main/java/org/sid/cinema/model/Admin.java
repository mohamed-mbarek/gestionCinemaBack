package org.sid.cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public String copy(String image) {
		String[] array=image.split("\\\\");
		return (array[2]);
	}
	
}
