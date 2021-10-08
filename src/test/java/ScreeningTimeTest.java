import com.cinemarcos.domain.valueobject.ScreeningTime;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ScreeningTimeTest {

    @Test
    void ignore_seconds_in_start_time() {
        LocalDateTime startTime = LocalDateTime.of(2021, Month.APRIL, 12, 22, 0, 45);

        ScreeningTime screeningTime = ScreeningTime.from(startTime);

        assertThat(screeningTime.startingTime()).isEqualTo(LocalDateTime.of(2021, Month.APRIL, 12, 22, 0));
    }

    @Test
    void customer_reserves_seats_for_screening_starting_at_specific_time_when_available_gets_status_ok() {
        LocalDateTime screeningTime = LocalDateTime.now();
        List<Integer> seats = Arrays.asList(42, 45, 89);

        ReserveSeatsForScreeningCommand command = new ReserveSeatsForScreeningCommand(seats, screeningTime);

        Screenings screenings = new Screenings() {
            @Override public Screening byTime(LocalDateTime time) {
                return new Screening();
            }
        };
        Boolean reserved = new SeatsReservationCommandHandler(screenings).handle(command);

        assertThat(reserved).isTrue();
    }


}
