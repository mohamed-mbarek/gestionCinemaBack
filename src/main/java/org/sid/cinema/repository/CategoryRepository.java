package org.sid.cinema.repository;

import org.sid.cinema.model.Categorie;
import org.sid.cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Categorie, Long> {

	Categorie findCategorieById(Long id);


}
