package org.sid.cinema.service;

import java.util.List;
import org.sid.cinema.exception.CustomerResourceException;
import org.sid.cinema.exception.VilleNotFoundException;
import org.sid.cinema.model.ProjectionFilm;
import org.sid.cinema.model.Reclamation;
import org.sid.cinema.model.Ticket;
import org.sid.cinema.model.Ville;
import org.sid.cinema.repository.ProjectionFilmRepository;
import org.sid.cinema.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	private final TicketRepository repository ;
	@Autowired
	public TicketService (  TicketRepository repository ) {
		this.repository=repository;
	}
	
	public Ticket addTicket(Ticket ticket) {
		return repository.save(ticket);
	
	}
	
	public List<Ticket> findAllTickets(){
		return repository.findAll();
	}
	
	public void deleteTicket(Long id ) {
		repository.deleteById(id);
	}
	public Ticket findTicketById(Long id) {
		return  repository.findTicketById(id);
	}
	
	public int countPlaceDispo(Long id) {
		ProjectionFilm nbRes=repository.verifProjection(id);
		if(nbRes==null)
			return 0;
		return repository.totalReservation(nbRes.getId());
	}
	
	public Ticket updateVu(Ticket ticket) {
		ticket.setVu(true);
		return repository.save(ticket);
	}
	public Integer nbRecNonVy() {
		return repository.findRecNonVu();
	}
	
	public List<Ticket> getHistorique(Long id) {
		return  repository.Historique(id);
	}
	
}
