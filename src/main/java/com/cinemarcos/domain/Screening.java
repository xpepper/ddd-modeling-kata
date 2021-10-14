package com.cinemarcos.domain;

import java.util.List;
import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Screening {
    private Long id;
    private List<Seat> seats;

    public Screening() {
        this(new Random(currentTimeMillis()).nextLong());
    }

    public Screening(Long id, Seat... seats) {
        this.id = id;
        this.seats = asList(seats);
    }

    public static Screening from(List<Event> events) {
        Screening screening = new Screening();
        events.forEach(screening::apply);
        return screening;
    }

    private void apply(Event event) {
        if (event instanceof ScreeningCreated) apply((ScreeningCreated) event);
        if (event instanceof ScreeningSeatsReserved) apply((ScreeningSeatsReserved) event);
    }

    private void apply(ScreeningCreated event) {
        id = event.id;
        seats = event.seats.stream().map(Seat::available).collect(toList());
    }

    private void apply(ScreeningSeatsReserved event) {
        List<Seat> seatsReserve = seatsToReserveFrom(event.seatNumbers);
        if (!seats.containsAll(seatsReserve)) return;

        seats.replaceAll(seat -> {
            if (seatsReserve.contains(seat)) return Seat.reserved(seat.seatNumber);
            return seat;
        });
    }

    public Boolean reserveSeats(List<Integer> seatNumbers) {
        List<Seat> seatsReserve = seatsToReserveFrom(seatNumbers);
        if (!seats.containsAll(seatsReserve)) return false;

        doReserve(seatsReserve);
        return true;
    }

    private List<Seat> seatsToReserveFrom(List<Integer> seatsToReserve) {
        return seatsToReserve.stream().map(Seat::available).collect(toList());
    }

    private void doReserve(List<Seat> seatsToReserve) {
        seats.replaceAll(seat -> {
            if (seatsToReserve.contains(seat)) return Seat.reserved(seat.seatNumber);
            return seat;
        });
    }
}
