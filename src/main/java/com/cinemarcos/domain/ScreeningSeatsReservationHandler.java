package com.cinemarcos.domain;

import java.util.List;
import java.util.function.Consumer;

public class ScreeningSeatsReservationHandler extends Handler {

    public ScreeningSeatsReservationHandler(List<Event> history, Consumer<Event> publisher) {
        super(history, publisher);
    }

    @Override
    public void handle(Command cmd) {
        if (cmd instanceof ReserveSeatsForScreening) {
            ReserveSeatsForScreening command = (ReserveSeatsForScreening) cmd;
            ScreeningState state = new ScreeningState(history);
            Screening seatsReservation = new Screening(state, e -> { state.apply(e); publisher.accept(e); });
            seatsReservation.reserveSeats(command.customerId, command.seats);
            return;
        }
        throw new IllegalArgumentException("Command not recognized");
    }
}