package com.cinemarcos.domain;

import java.util.List;

public class ScreeningSeatsReserved extends Event {
    public final Long id;
    public final List<Integer> seatNumbers;

    public ScreeningSeatsReserved(Long id, List<Integer> seatNumbers) {
        this.id = id;
        this.seatNumbers = seatNumbers;
    }

}
