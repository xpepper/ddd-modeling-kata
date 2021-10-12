import java.util.List;

public class Screening {
    private final List<Seat> seats;

    public Screening(List<Seat> seats) {
        this.seats = seats;
    }

    Boolean reserveSeats(List<Integer> seatsToReserve) {
        for (Integer seatToReserve : seatsToReserve) {
            if (!seats.contains(new Seat(seatToReserve, true))) {
                return false;
            }
        }
        return true;
    }
}
