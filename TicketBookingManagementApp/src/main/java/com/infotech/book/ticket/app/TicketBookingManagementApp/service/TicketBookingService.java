package com.infotech.book.ticket.app.TicketBookingManagementApp.service;

import com.infotech.book.ticket.app.TicketBookingManagementApp.dao.TicketBookingDao;
import com.infotech.book.ticket.app.TicketBookingManagementApp.entities.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {



    private final TicketBookingDao ticketBookingDao;

    public TicketBookingService(TicketBookingDao ticketBookingDao) {

        this.ticketBookingDao = ticketBookingDao;
    }

    public Ticket createTicket(Ticket ticket) {

        return ticketBookingDao.save(ticket);
    }

    public Ticket getTicketById(Integer ticketId) {
        return ticketBookingDao.findOne(ticketId);
    }

    public Iterable<Ticket> getAllBookedTickets() {
        return ticketBookingDao.findAll();
    }

    public void deleteTicket(Integer ticketId) {
        ticketBookingDao.delete(ticketId);
    }

    public Ticket updateTicket(Integer ticketId, String newEmail) {
        Ticket ticketFromDb = ticketBookingDao.findOne(ticketId);
        ticketFromDb.setEmail(newEmail);
        return ticketBookingDao.save(ticketFromDb);
    }
}
