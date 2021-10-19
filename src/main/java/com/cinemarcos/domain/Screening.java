package com.cinemarcos.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_CLASS_NAME_STYLE;

public class Screening {
    private Long id;
    private List<Seat> seats;
    private final Consumer<Event> eventPublisher;

    private Screening(Consumer<Event> eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public static Screening from(List<Event> events, Consumer<Event> eventPublisher) {
        Screening screening = new Screening(eventPublisher);
        events.forEach(screening::apply);
        return screening;
    }

    static Screening from(Consumer<Event> eventPublisher, Event... events) {
        return from(asList(events), eventPublisher);
    }

    public Boolean reserveSeats(List<Integer> seatNumbers) {
        List<Seat> seatsReserve = seatsToReserveFrom(seatNumbers);
        if (!seats.containsAll(seatsReserve)) return false;

        doReserve(seatsReserve);
        eventPublisher.accept(new ScreeningSeatsReserved(id, seatNumbers));
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, NO_CLASS_NAME_STYLE);
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
