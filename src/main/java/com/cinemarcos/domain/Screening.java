package com.cinemarcos.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Screening {

    ScreeningState state;

    Consumer<Event> publisher;

    public Screening(ScreeningState state, Consumer<Event> publisher) {
        this.state = state;
        this.publisher = publisher;
    }

    public String id() {
        return state.id();
    }

    public void reserveSeats(String customerId, Set<Integer> seats) {
        if (state.availableSeats.containsAll(seats)) {
            publisher.accept(new TicketsForScreeningReserved(customerId, state.id(), seats));
        } else {
            publisher.accept(new TicketsForScreeningReservationFailed(customerId, state.id(), seats));
        }
    }
}
