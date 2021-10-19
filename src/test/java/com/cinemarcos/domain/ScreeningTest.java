package com.cinemarcos.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ScreeningTest {

    private static final long AN_ID = 123L;
    private SpyEventPublisher eventPublisher;

    @BeforeEach
    public void setUp() {
        eventPublisher = new SpyEventPublisher();
    }

    @Test
    void reserve_seats_when_available() {
        Screening screening = Screening.from(
            eventPublisher::publish,
            new ScreeningCreated(AN_ID, asList(1, 2, 3)),
            new ScreeningSeatsReserved(AN_ID, asList(2, 3))
        );

        assertThat(screening.reserveSeats(asList(1))).isTrue();
        assertThat(eventPublisher.publishedEvent).isEqualTo(new ScreeningSeatsReserved(AN_ID, asList(1)));
    }

    @Test
    void does_not_reserve_seat_when_at_least_one_is_unavailable() {
        Screening screening = Screening.from(
            eventPublisher::publish,
            new ScreeningCreated(AN_ID, asList(1, 2, 3)),
            new ScreeningSeatsReserved(AN_ID, asList(3))
        );

        assertThat(screening.reserveSeats(asList(1, 3))).isFalse();
    }

    @Test
    void cannot_reserve_twice_the_same_seats() {
        Screening screening = Screening.from(
            eventPublisher::publish,
            new ScreeningCreated(AN_ID, asList(1, 2, 3)),
            new ScreeningSeatsReserved(AN_ID, asList(2))
        );

        assertThat(screening.reserveSeats(asList(1))).isTrue();
        assertThat(screening.reserveSeats(asList(1))).isFalse();
    }

    @Test
    void does_not_reserve_seat_when_unavailable() {
        Screening screening = Screening.from(
            eventPublisher::publish,
            new ScreeningCreated(AN_ID, asList(1, 2, 3)),
            new ScreeningSeatsReserved(AN_ID, asList(1))
        );

        assertThat(screening.reserveSeats(asList(1))).isFalse();
    }

    class SpyEventPublisher {
        Event publishedEvent;

        void publish(Event event) {
            this.publishedEvent = event;
        }
    }
}

