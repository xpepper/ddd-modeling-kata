package com.cinemarcos.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ReserveSeatsCommandHandlerTest {

    private static final long A_SCREENING_ID = 123L;

    @Test
    void customer_can_reserve_seats_when_all_available() {
        List<Integer> seats = asList(42, 45, 89);
        SpyScreeningRepository screeningRepository = new SpyScreeningRepository();
        ReserveSeatsCommand command = new ReserveSeatsCommand(A_SCREENING_ID, seats);

        Boolean reserved = new ReserveSeatsCommandHandler(screeningRepository).handle(command);

        assertThat(screeningRepository.hasBeenSaved()).isTrue();
        assertThat(reserved).isTrue();
    }

    @Test
    void customer_cannot_reserve_seats_when_not_available() {
        List<Integer> seats = asList(7, 5);
        SpyScreeningRepository screeningRepository = new SpyScreeningRepository();
        ReserveSeatsCommand command = new ReserveSeatsCommand(A_SCREENING_ID, seats);

        Boolean reserved = new ReserveSeatsCommandHandler(screeningRepository).handle(command);

        assertThat(screeningRepository.hasBeenSaved()).isFalse();
        assertThat(reserved).isFalse();
    }

    static class SpyScreeningRepository implements ScreeningRepository {
        public static final Screening SCREENING = new Screening(
                A_SCREENING_ID,
                Seat.available(1),
                Seat.available(3),
                Seat.available(42),
                Seat.available(45),
                Seat.available(89)
        );
        private boolean hasBeenSaved = false;

        @Override
        public Screening byId(Long id) {
            return SCREENING;
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
