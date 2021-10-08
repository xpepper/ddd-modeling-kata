import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ReserveSeatsForScreeningTest {

    @Test
    void customer_reserves_seats_for_screening_starting_at_specific_time_when_available_gets_status_ok() {
        LocalDateTime screeningTime = LocalDateTime.now();
        List<Integer> seats = Arrays.asList(42, 45, 89);
        Screenings screenings = scheduleTime -> new Screening();

        ReserveSeatsForScreeningCommand command = new ReserveSeatsForScreeningCommand(seats, screeningTime);

        Boolean reserved = new SeatsReservationCommandHandler(screenings).handle(command);

        assertThat(reserved).isTrue();
    }


}
