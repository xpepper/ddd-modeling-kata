public class ReserveSeatsCommandHandler {
    private final ScreeningRepository screenings;

    public ReserveSeatsCommandHandler(ScreeningRepository screeningRepository) {
        this.screenings = screeningRepository;
    }

    public Boolean handle(ReserveSeatsCommand command) {
        Screening screening = screenings.byTime(command.time);
        return screening.reserveSeats(command.seats);
    }
}
