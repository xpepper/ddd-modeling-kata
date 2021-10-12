import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ReserveSeatsCommandHandlerTest {

    @Test
    void customer_can_reserves_seats_when_all_available() {
        LocalDateTime screeningTime = LocalDateTime.now();
        List<Integer> seats = asList(42, 45, 89);
        ScreeningRepository screeningRepository = scheduleTime -> new Screening(asList(
                new Seat(1, true),
                new Seat(3, true),
                new Seat(42, true),
                new Seat(45, true),
                new Seat(89, true))
        );
        ReserveSeatsCommand command = new ReserveSeatsCommand(seats, screeningTime);

        Boolean reserved = new ReserveSeatsCommandHandler(screeningRepository).handle(command);

        assertThat(reserved).isTrue();
    }
}
