package org.sid.cinema.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Affiche {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String image;
	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)

	private Film film;
	

	public String copy(String image) {
		String[] array=image.split("\\\\");
		return (array[2]);
	}
}

