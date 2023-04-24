package com.gl.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Ticket;
import com.gl.repository.TicketRepository;
import com.gl.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void addTicket(Ticket t) {
		ticketRepository.save(t);

	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(int id) {

		Optional<Ticket> t = ticketRepository.findById(id);
		if (t.isPresent()) {
			return t.get();
		}
		return null;
	}

	@Override
	public void delTicket(int id) {
		ticketRepository.deleteById(id);

	}

	@Override
	public List<Ticket> getByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

}
