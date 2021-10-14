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
