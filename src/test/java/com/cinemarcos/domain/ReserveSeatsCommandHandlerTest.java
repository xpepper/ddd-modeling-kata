package com.cinemarcos.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ReserveSeatsCommandHandlerTest {

    private static final long A_SCREENING_ID = 123L;
    private EvenStore eventStore;

    @BeforeEach
    void setUp() {
        eventStore = new InMemoryEventStore();
    }

    @Test
    void customer_can_reserve_seats_when_all_available() {
        eventStore.append(new ScreeningCreated(A_SCREENING_ID, asList(1, 2, 3)));

        ReserveSeatsCommand command = new ReserveSeatsCommand(A_SCREENING_ID, asList(1, 2));
        Boolean reserved = new ReserveSeatsCommandHandler(eventStore).handle(command);

        assertThat(reserved).isTrue();
    }

    @Test
    void customer_cannot_reserve_seats_when_not_available() {
        eventStore.append(new ScreeningCreated(A_SCREENING_ID, asList(1, 2, 3)));

        ReserveSeatsCommand command = new ReserveSeatsCommand(A_SCREENING_ID, asList(7, 5));
        Boolean reserved = new ReserveSeatsCommandHandler(eventStore).handle(command);

        assertThat(reserved).isFalse();
    }
}
