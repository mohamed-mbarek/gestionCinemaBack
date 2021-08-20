package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.exception.CustomerResourceException;
import org.sid.cinema.model.ProjectionFilm;
import org.sid.cinema.model.Reclamation;
import org.sid.cinema.model.Ticket;
import org.sid.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private final TicketService service;

	public TicketController(TicketService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Ticket>> getAllTickets() {
		List<Ticket> Tickets = service.findAllTickets();
		return new ResponseEntity<>(Tickets, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id) {
		Ticket Ticket = service.findTicketById(id);
		return new ResponseEntity<>(Ticket, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket Ticket) {
		Ticket newTicket = service.addTicket(Ticket);
		return new ResponseEntity<>(newTicket, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id) {
		service.deleteTicket(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/verification/{id}")
	public ResponseEntity<Integer> getVerification(@PathVariable("id") Long id) {
		int i = service.countPlaceDispo(id);
		return new ResponseEntity<>(i, HttpStatus.OK);
	}

	@PutMapping("/updateVu")
	public ResponseEntity<Ticket> updateVuReclamation(@RequestBody Ticket ticket) throws ParseException {
		Ticket updateTicket = service.updateVu(ticket);
		return new ResponseEntity<>(updateTicket, HttpStatus.OK);
	}

	@GetMapping("/nbRecNonVu")
	public ResponseEntity<Integer> countNbRecNonVu() {
		Integer i = this.service.nbRecNonVy();
		return new ResponseEntity<>(i, HttpStatus.OK);
	}	
	
	@GetMapping("/historique/{id}")
	public ResponseEntity<List<Ticket>> getAllHistoriques(@PathVariable("id")Long id) {
		List<Ticket> Tickets = service.getHistorique(id);
		return new ResponseEntity<>(Tickets, HttpStatus.OK);
	}


}
