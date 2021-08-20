package org.sid.cinema.repository;

import java.util.List;

import org.sid.cinema.model.Cinema;
import org.sid.cinema.model.ProjectionFilm;
import org.sid.cinema.model.Salle;
import org.sid.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	Ticket findTicketById(Long id);

	@Query("select sum(t.nombre) from Ticket t  where t.projection.id=?1")
	int totalReservation(Long id );
	
	@Query("select t.projection from Ticket t where t.projection.id=?1")
	ProjectionFilm verifProjection(Long id );
	
	@Query("select count(t) from Ticket t   where vu='false'")
	Integer findRecNonVu ();
	
	@Query("select t from Ticket t where t.admin.id=?1")
	List<Ticket> Historique(Long id );
	
}
