package com.cinemarcos.domain;

import java.util.Objects;

public class ReservedSeat {

    private final String customerId;
    private final int seat;

    public ReservedSeat(String customerId, int seat) {
        this.customerId = customerId;
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedSeat that = (ReservedSeat) o;
        return seat == that.seat &&
                customerId.equals(that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, seat);
    }
}