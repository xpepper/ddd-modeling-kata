import com.cinemarcos.domain.valueobject.ScreeningTime;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ScreeningTest {

    @Test
    void reserve_seats_when_available() {
        Screening screening = new Screening(asList(new Seat(1, true), new Seat(2, false)));
        Boolean reserved = screening.reserveSeats(asList(1));

        assertThat(reserved).isTrue();
    }

    @Test
    void does_not_reserve_seat_when_unavailable() {
        Screening screening = new Screening(asList(new Seat(1, true), new Seat(2, false)));
        Boolean reserved = screening.reserveSeats(asList(2));

        assertThat(reserved).isFalse();
    }
}
