package org.sid.cinema.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cinema implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int nombreSalles;
	private String adress;
	private String description;
	@Column(columnDefinition = "varchar(25) default 'cinema.jpg'")
	private String image;
	@OneToMany(mappedBy = "cinema",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Collection<Salle> salles;
	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Ville ville;
	
	public String copy(String image) {
		String[] array=image.split("\\\\");
		return (array[2]);
	}
}
