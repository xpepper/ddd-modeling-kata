import java.util.List;

import static java.util.stream.Collectors.toList;

public class Screening {
    private final List<Seat> seats;

    public Screening(List<Seat> seats) {
        this.seats = seats;
    }

    Boolean reserveSeats(List<Integer> seatsToReserve) {
        for (Integer seatToReserve : seatsToReserve) {
            if (!seats.contains(Seat.available(seatToReserve))) return false;
        }
        List<Seat> toReserve = seatsToReserve.stream().map(Seat::available).collect(toList());
        seats.replaceAll(seat -> {
            if (toReserve.contains(seat)) return Seat.reserved(seat.seatNumber);
            return seat;
        });
        return true;
    }
}
