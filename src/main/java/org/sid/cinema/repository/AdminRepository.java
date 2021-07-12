package org.sid.cinema.repository;

import org.sid.cinema.model.Admin;
import org.sid.cinema.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findAdminById(Long id);

}
