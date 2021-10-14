package com.cinemarcos.domain;

import java.util.List;

public class ReserveSeatsCommandHandler {
    private final ScreeningRepository screenings;
    private EvenStore eventStore;

    public ReserveSeatsCommandHandler(ScreeningRepository screeningRepository) {
        this.screenings = screeningRepository;
        eventStore = new InMemoryEventStore();
    }

    public ReserveSeatsCommandHandler(EvenStore eventStore) {
        this.screenings = null;
        this.eventStore = eventStore;
    }

//    public Boolean handle(ReserveSeatsCommand command) {
//        Screening screening = screenings.byId(command.screeningId);
//        Boolean seatsReserved = screening.reserveSeats(command.seats);
//        if (seatsReserved)
//            screenings.save(screening);
//
//        return seatsReserved;
//    }

    public Boolean handle(ReserveSeatsCommand command) {
        List<Event> events = eventStore.allEventsById(command.screeningId);
        Screening screening = Screening.from(events);
        Boolean seatsReserved = screening.reserveSeats(command.seats);
        eventStore.append(new ScreeningSeatsReserved(command.screeningId, command.seats));

        return seatsReserved;
    }

}
