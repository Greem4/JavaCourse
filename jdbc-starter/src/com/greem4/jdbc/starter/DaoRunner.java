package com.greem4.jdbc.starter;

import com.greem4.jdbc.starter.dao.TicketDao;
import com.greem4.jdbc.starter.entity.Ticket;

import java.math.BigDecimal;

public class DaoRunner {

    public static void main(String[] args) {
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
