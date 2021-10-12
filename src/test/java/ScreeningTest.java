import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScreeningTest {

    @Test
    void reserve_seats_when_available() {
        Screening screening = new Screening(Seat.available(1), Seat.reserved(2));
        Boolean reserved = screening.reserveSeats(asList(1));

        assertThat(reserved).isTrue();
    }

    @Test
    void does_not_reserve_seat_when_unavailable() {
        Screening screening = new Screening(Seat.available(1), Seat.reserved(2));
        Boolean reserved = screening.reserveSeats(asList(2));

        assertThat(reserved).isFalse();
    }

    @Test
    void does_not_reserve_seat_when_at_least_one_is_unavailable() {
        Screening screening = new Screening(Seat.available(1), Seat.available(2), Seat.reserved(3));
        Boolean reserved = screening.reserveSeats(asList(1, 3));

        assertThat(reserved).isFalse();
    }

    @Test
    void cannot_reserve_twice_the_same_seats() {
        Screening screening = new Screening(Seat.available(1), Seat.reserved(2));
        assertTrue(screening.reserveSeats(asList(1)));

        Boolean reserved = screening.reserveSeats(asList(1));

        assertThat(reserved).isFalse();
    }
}
