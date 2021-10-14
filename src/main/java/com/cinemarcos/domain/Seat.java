package com.cinemarcos.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Seat {
    final int seatNumber;
    private boolean isAvailable;

    private Seat(int seatNumber, boolean isAvailable) {
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    public static Seat available(int seatNumber) {
        return new Seat(seatNumber, true);
    }

    static Seat reserved(int seatNumber) {
        return new Seat(seatNumber, false);
    }

    public void reserve() {
        isAvailable = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        return new EqualsBuilder().append(seatNumber, seat.seatNumber).append(isAvailable, seat.isAvailable).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(seatNumber).append(isAvailable).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("seatNumber", seatNumber)
            .append("isReserved", isAvailable)
            .toString();
    }
}
