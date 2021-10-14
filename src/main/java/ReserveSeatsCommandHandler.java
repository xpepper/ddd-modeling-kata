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
    * add an ID to the Screening aggregate to be able to retrive only its events
    * introduce an event store (as a dependency to the command handler) to read the events to pass to Screening.from(event) (we have to get the events from somewhere)
    * Screening#researveSeats has to fire a ScreeningSeatsReserved (e.g. `eventstore.publish(event)`)
    * Event store has to store the events
    * add a scheduleTime to Screening (we forgot to add it before...)

*/

