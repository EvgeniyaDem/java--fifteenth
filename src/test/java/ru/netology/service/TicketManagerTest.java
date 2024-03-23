package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {
    @Test

    public void ShouldFindAndSortSomeTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 100, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12);
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15);
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket1, ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void ShouldFindAndSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12);
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15);
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 100, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MSK", "PKS");
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void ShouldFindAndSortNoTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12);
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15);
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 100, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("PKS", "MSK");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void ShouldFindAndSortSomeTicketsWithComparator1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 13); //3
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12); //
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15); //
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16); //
        Ticket ticket5 = new Ticket("MSK", "SPB", 100, 12, 14); //2
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket5, ticket1};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void ShouldFindAndSortSomeTicketsWithComparator2() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 13); //3
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12); //
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15); //
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16); //
        Ticket ticket5 = new Ticket("MSK", "SPB", 100, 12, 16); //4
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket1, ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void ShouldFindAndSortSomeTicketsWithComparator3() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 13); //3
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12); //
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15); //
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16); //
        Ticket ticket5 = new Ticket("MSK", "SPB", 100, 12, 17); //3
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket1, ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void ShouldFindAndSortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12);
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15);
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 100, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "PKS", comparator);
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void ShouldFindAndSortNoTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "NSK", 300, 7, 12);
        Ticket ticket3 = new Ticket("NSK", "MSK", 500, 10, 15);
        Ticket ticket4 = new Ticket("MSK", "PKS", 400, 8, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 100, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SPB", "MSK", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }


}
//end