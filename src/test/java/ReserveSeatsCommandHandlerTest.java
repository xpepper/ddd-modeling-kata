import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ReserveSeatsCommandHandlerTest {

    @Test
    void customer_can_reserves_seats_when_all_available() {
        LocalDateTime screeningTime = LocalDateTime.now();
        List<Integer> seats = Arrays.asList(42, 45, 89);
        ScreeningRepository screenings = scheduleTime -> new Screening();
        ReserveSeatsCommand command = new ReserveSeatsCommand(seats, screeningTime);

        Boolean reserved = new ReserveSeatsCommandHandler(screenings).handle(command);

        assertThat(reserved).isTrue();
    }
}
