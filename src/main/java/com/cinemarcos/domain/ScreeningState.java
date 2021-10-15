package com.cinemarcos.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ScreeningState {

    private String id = "2";
    private String title = "Forrest Gamp";
    public Set<Integer> availableSeats = new HashSet<>(Arrays.asList(1, 2, 3, 4));
    private Set<ReservedSeat> reservedSeats = new HashSet<>();

    public ScreeningState(List<Event> history) {
        for (Event event : history) {
            apply(event);
        }
    }

    public void apply(Event event) {
        if (event instanceof TicketsForScreeningReserved) {
            apply((TicketsForScreeningReserved) event);
        }
        if (event instanceof TicketsForScreeningReservationFailed) {
            apply((TicketsForScreeningReservationFailed) event);
        }
    }

    public void apply(TicketsForScreeningReserved event) {
        Set<Integer> requestedSeats = event.seats;
        Set<Integer> seatsAvailable = availableSeats.stream().filter(seat -> requestedSeats.contains(seat)).collect(Collectors.toSet());
        if (requestedSeats.size() == seatsAvailable.size()) {
            availableSeats.removeAll(requestedSeats);
            reservedSeats.addAll(
                    requestedSeats.stream().map(s -> new ReservedSeat(event.customerId, Integer.valueOf(s)))
                            .collect(Collectors.toSet())
            );
        }
    }

    public void apply(TicketsForScreeningReservationFailed event) {
    }

    public String id() {
        return id;
    }

}