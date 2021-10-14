import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Screening {
    private List<Seat> seats;

    public Screening(Seat... seats) {
        this.seats = asList(seats);
    }

    public static Screening from(List<Event> events) {
        Screening screening = new Screening();
        events.forEach(event -> screening.apply(event));
        return screening;
    }

    private void apply(Event event) {
        if (event instanceof ScreeningCreated) apply((ScreeningCreated) event);
        if (event instanceof ScreeningSeatsReserved) apply((ScreeningSeatsReserved) event);
    }

    private void apply(ScreeningCreated event) {
        seats = event.seats.stream().map(Seat::available).collect(toList());
    }

    private void apply(ScreeningSeatsReserved event) {
        List<Seat> seatsReserve = seatsToReserveFrom(event.seatNumbers);
        if (!seats.containsAll(seatsReserve)) return;

        seats.replaceAll(seat -> {
            if (seatsReserve.contains(seat)) return Seat.reserved(seat.seatNumber);
            return seat;
        });
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
