package com.infotech.book.ticket.app.TicketBookingManagementApp;

import com.infotech.book.ticket.app.TicketBookingManagementApp.entities.Ticket;
import com.infotech.book.ticket.app.TicketBookingManagementApp.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.Date;

@SpringBootApplication
public class TicketBookingManagementAppApplication implements CommandLineRunner {

	@Autowired
	private TicketBookingService ticketBookingService;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingManagementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestStation("Mumbai");
		ticket.setSourceStation("Pune");
		ticket.setPassengerName("KK");
		ticket.setEmail("kk@yahoo.com");

		ticketBookingService.createTicket(ticket);

		System.out.println("DataSource::"+dataSource);
		}
    }
