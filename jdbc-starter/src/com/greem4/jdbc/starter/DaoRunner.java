package com.greem4.jdbc.starter;

import com.greem4.jdbc.starter.dao.TicketDao;
import com.greem4.jdbc.starter.entity.Ticket;

import java.math.BigDecimal;
import java.util.List;

public class DaoRunner {

    public static void main(String[] args) {
        var tickets = TicketDao.getInstance().findAll();
        System.out.println();
    }

    private static void updateTest() {
        var ticketDao = TicketDao.getInstance();
        var maybeTicket = ticketDao.findById(2L);
        System.out.println(maybeTicket);

        maybeTicket.ifPresent(ticket -> {
            ticket.setCost(BigDecimal.valueOf(188.88));
            ticketDao.update(ticket);
        });
    }

    private static void deleteTest() {
        var ticketDao = TicketDao.getInstance();
        ticketDao.delete(56L);
    }

    private static void saveTest() {
        var ticketDao = TicketDao.getInstance();
        var ticket = new Ticket();
        ticket.setPassengerNo("1234567");
        ticket.setPassengerName("Test");
        ticket.setFlightId(3L);
        ticket.setSeatNo("B3");
        ticket.setCost(BigDecimal.TEN);
        var saveTicket = ticketDao.save(ticket);
        System.out.println(saveTicket);
    }
}
