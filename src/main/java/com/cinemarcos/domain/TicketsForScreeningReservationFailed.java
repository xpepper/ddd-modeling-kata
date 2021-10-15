package com.cinemarcos.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;
import java.util.Set;

public class TicketsForScreeningReservationFailed extends Event {

    public String customerId;

    public String screeningId;

    public Set<Integer> seats;

    public TicketsForScreeningReservationFailed(String customerId, String screeningId, Set<Integer> seats) {
        this.customerId = customerId;
        this.screeningId = screeningId;
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsForScreeningReservationFailed that = (TicketsForScreeningReservationFailed) o;
        return customerId.equals(that.customerId) &&
                screeningId.equals(that.screeningId) &&
                seats.equals(that.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, screeningId, seats);
    }

    @Override public String toString() {
        return new ToStringBuilder(this)
                .append("customerId", customerId)
                .append("screeningId", screeningId)
                .append("seats", seats)
                .toString();
    }
}