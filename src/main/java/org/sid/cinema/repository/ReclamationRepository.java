package org.sid.cinema.repository;

import java.util.List;

import org.sid.cinema.model.Reclamation;
import org.sid.cinema.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReclamationRepository  extends JpaRepository<Reclamation, Long>{

	@Query("select count(*) from Reclamation   where vu='false'")
	int findRecNonVu ();

}
