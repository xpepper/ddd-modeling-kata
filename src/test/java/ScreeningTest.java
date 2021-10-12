import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScreeningTest {

    @Test
    void reserve_seats_when_available() {
        Screening screening = new Screening(asList(new Seat(1, true), new Seat(2, false)));
        Boolean reserved = screening.reserveSeats(asList(2));

        assertThat(reserved).isTrue();
    }

    @Test
    void does_not_reserve_seat_when_unavailable() {
        Screening screening = new Screening(asList(new Seat(1, true), new Seat(2, false)));
        Boolean reserved = screening.reserveSeats(asList(1));

        assertThat(reserved).isFalse();
    }

    @Test
    @Disabled
    void cannot_reserve_twice_the_same_seats() {
        Screening screening = new Screening(asList(new Seat(1, true), new Seat(2, false)));
        assertTrue(screening.reserveSeats(asList(1)));

        Boolean reserved = screening.reserveSeats(asList(1));

        assertThat(reserved).isFalse();
    }
}
