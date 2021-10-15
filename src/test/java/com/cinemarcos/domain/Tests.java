package com.cinemarcos.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Arrays.asList;

@SuppressWarnings("ALL") public class Tests extends TicketReservationTestFixture {

    // The customer wants to see the available seats of the screening,
    // chooses from the list which ones to reserve and gets informed about success or failure of the reservation.
    // The reservation is only possible up to 15 minutes before the screening.
    // Write two tests to ensure each business rule from the scenario by only using the commands and  events in your test.
    @Test
    void customer_can_reserve_available_seats() {
        Given(asList(new TicketsForScreeningReserved("123", "2", new HashSet<>(asList(1)))));

        When(new ReserveSeatsForScreening("123", new HashSet<>(asList(2)), "2"));

        Then_expect(asList(new TicketsForScreeningReserved("123", "2", new HashSet<>(asList(2)))));
    }

    @Test
    void customer_cannot_reserve_seats_which_are_already_reserved() {
        Given(asList(new TicketsForScreeningReserved("123", "2", new HashSet<>(asList(1, 2)))));

        When(new ReserveSeatsForScreening("123", new HashSet<>(asList(1, 2)), "2"));

        Then_expect(asList(new TicketsForScreeningReservationFailed("123", "2", new HashSet<>(asList(1, 2)))));
    }

    @Test
    void customer_cannot_reserve_seats_when_is_left_less_then_15_minutes_to_the_screening() {
    }
}
