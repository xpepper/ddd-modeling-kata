package com.cinemarcos.domain;

import java.util.List;

public class ReserveSeatsCommandHandler {
    private final EvenStore eventStore;

    public ReserveSeatsCommandHandler(EvenStore eventStore) {
        this.eventStore = eventStore;
    }

    public Boolean handle(ReserveSeatsCommand command) {
        List<Event> events = eventStore.allEventsById(command.screeningId);
        Screening screening = Screening.from(eventStore::append, events);

        return screening.reserveSeats(command.seats);
    }
}
