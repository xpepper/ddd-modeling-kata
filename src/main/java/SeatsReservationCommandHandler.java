public class SeatsReservationCommandHandler {
    private final Screenings screenings;

    public SeatsReservationCommandHandler(Screenings screenings) {
        this.screenings = screenings;
    }

    public Boolean handle(ReserveSeatsForScreeningCommand command) {
        Screening screening = screenings.byTime(command.time);
        Boolean areAvailable = screening.reserveSeats(command.seats);
        return areAvailable;
    }
}
