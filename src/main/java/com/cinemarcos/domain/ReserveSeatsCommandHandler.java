package com.cinemarcos.domain;

public class ReserveSeatsCommandHandler {
    private final ScreeningRepository screenings;

    public ReserveSeatsCommandHandler(ScreeningRepository screeningRepository) {
        this.screenings = screeningRepository;
    }

    public Boolean handle(ReserveSeatsCommand command) {
        Screening screening = screenings.byTime(command.time);
        Boolean seatsReserved = screening.reserveSeats(command.seats);
        if (seatsReserved)
            screenings.save(screening);

        return seatsReserved;
    }
}
/*
TODO:
    * add an ID to the com.cinemarcos.domain.Screening aggregate to be able to retrive only its events
    * introduce an event store (as a dependency to the command handler) to read the events to pass to com.cinemarcos.domain.Screening.from(event) (we have to get the events from somewhere)
    * com.cinemarcos.domain.Screening#researveSeats has to fire a com.cinemarcos.domain.ScreeningSeatsReserved (e.g. `eventstore.publish(event)`)
    * com.cinemarcos.domain.Event store has to store the events
    * add a scheduleTime to com.cinemarcos.domain.Screening (we forgot to add it before...)

*/

