package com.cinemarcos.domain;

import java.util.List;

public class ReserveSeatsCommandHandler {
    private final EvenStore eventStore;

    public ReserveSeatsCommandHandler(EvenStore eventStore) {
        this.eventStore = eventStore;
    }

    public Boolean handle(ReserveSeatsCommand command) {
        List<Event> events = eventStore.allEventsById(command.screeningId);
        Screening screening = Screening.from(events);
        Boolean seatsReserved = screening.reserveSeats(command.seats);
        eventStore.append(new ScreeningSeatsReserved(command.screeningId, command.seats));

        return seatsReserved;
    }

}
