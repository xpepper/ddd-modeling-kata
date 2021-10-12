import java.util.List;
import java.util.stream.Collectors;

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
        seatsToReserve.stream().forEach(seat ->
            seats.stream().filter(screeningSeat ->
                    screeningSeat.seatNumber == seat)
                .collect(Collectors.toList()).get(0)
                .reserve()
        );
        return true;
    }
}
