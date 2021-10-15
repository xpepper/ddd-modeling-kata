package com.cinemarcos.domain;

public class TicketReservationTestFixture extends AbstractTestFixture {
    @Override
    public void When(Command cmd) {
        ScreeningSeatsReservationHandler handler = new ScreeningSeatsReservationHandler(
                history, e -> publishedEvents.add(e)
        );
        handler.handle(cmd);
    }
}