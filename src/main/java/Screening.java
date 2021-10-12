import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Screening {
    private final List<Seat> seats;

    public Screening(List<Seat> seats) {
        this.seats = seats;
    }

    public Screening(Seat... seats) {
        this.seats = asList(seats);
    }

    Boolean reserveSeats(List<Integer> seatsToReserve) {
        List<Seat> toReserve = seatsToReserve.stream().map(Seat::available).collect(toList());
        if (!seats.containsAll(toReserve)) return false;

        seats.replaceAll(seat -> {
            if (toReserve.contains(seat)) return Seat.reserved(seat.seatNumber);
            return seat;
        });
        return true;
    }
}
