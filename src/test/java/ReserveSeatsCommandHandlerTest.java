import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ReserveSeatsCommandHandlerTest {

    @Test
    void customer_can_reserve_seats_when_all_available() {
        LocalDateTime screeningTime = LocalDateTime.now();
        List<Integer> seats = asList(42, 45, 89);
        SpyScreeningRepository screeningRepository = new SpyScreeningRepository();
        ReserveSeatsCommand command = new ReserveSeatsCommand(seats, screeningTime);

        Boolean reserved = new ReserveSeatsCommandHandler(screeningRepository).handle(command);

        assertThat(screeningRepository.hasBeenSaved()).isTrue();
        assertThat(reserved).isTrue();
    }

    @Test
    void customer_cannot_reserve_seats_when_not_available() {
        LocalDateTime screeningTime = LocalDateTime.now();
        List<Integer> seats = asList(7, 5);
        SpyScreeningRepository screeningRepository = new SpyScreeningRepository();
        ReserveSeatsCommand command = new ReserveSeatsCommand(seats, screeningTime);

        Boolean reserved = new ReserveSeatsCommandHandler(screeningRepository).handle(command);

        assertThat(screeningRepository.hasBeenSaved()).isFalse();
        assertThat(reserved).isFalse();
    }

    static class SpyScreeningRepository implements ScreeningRepository {
        private boolean hasBeenSaved = false;

        @Override
        public Screening byTime(LocalDateTime scheduleTime) {
            return new Screening(
                Seat.available(1),
                Seat.available(3),
                Seat.available(42),
                Seat.available(45),
                Seat.available(89)
            );
        }

        @Override
        public void save(Screening screening) {
            hasBeenSaved = true;
        }

        public Boolean hasBeenSaved() {
            return hasBeenSaved;
        }
    }
}
