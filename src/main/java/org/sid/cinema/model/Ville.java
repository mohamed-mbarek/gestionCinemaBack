package org.sid.cinema.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.el.parser.AstString;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity 
@Data @AllArgsConstructor @NoArgsConstructor
public class Ville  {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String nom ;
	private Long codePostal ;
	private String image ;
	@OneToMany (mappedBy = "ville")
	@JsonIgnore
	private Collection<Cinema> cinemas ;
	
	
	public String copy(String image) {
		String[] array=image.split("\\\\");
		return (array[2]);
	}
}
