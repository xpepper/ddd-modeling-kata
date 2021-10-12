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

    Boolean reserveSeats(List<Integer> seatNumbers) {
        List<Seat> seatsReserve = seatsToReserveFrom(seatNumbers);
        if (!seats.containsAll(seatsReserve)) return false;

        doReserve(seatsReserve);
        return true;
    }

    private List<Seat> seatsToReserveFrom(List<Integer> seatsToReserve) {
        return seatsToReserve.stream().map(Seat::available).collect(toList());
    }

    private void doReserve(List<Seat> seatsToReserve) {
        seats.replaceAll(seat -> {
            if (seatsToReserve.contains(seat)) return Seat.reserved(seat.seatNumber);
            return seat;
        });
    }
}
