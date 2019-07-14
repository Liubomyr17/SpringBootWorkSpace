package com.infotech.book.ticket.app.TicketBookingManagementApp.controller;

import com.infotech.book.ticket.app.TicketBookingManagementApp.entities.Ticket;
import com.infotech.book.ticket.app.TicketBookingManagementApp.service.TicketBookingService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {

    private final TicketBookingService ticketBookingService;

    public TicketBookingController(TicketBookingService ticketBookingService) {
        this.ticketBookingService = ticketBookingService;
    }

    @PostMapping(value = "/create")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketBookingService.createTicket(ticket);
    }

    @GetMapping(value = "/ticket/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
        return ticketBookingService.getTicketById(ticketId);
    }

    @GetMapping(value = "/ticket/alltickets")
    public Iterable<Ticket> getAllBookedTickets() {
        return ticketBookingService.getAllBookedTickets();
    }

    @DeleteMapping(value = "/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId")Integer ticketId) {
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping(value = "/ticket/{ticketId}/{newEmail:.+}")
    public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId, @PathVariable("newEmail")String newEmail) {
        return ticketBookingService.updateTicket(ticketId, newEmail);


    }
}
