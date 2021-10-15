package com.cinemarcos.domain;

import java.util.List;

public class ScreeningSeatsReserved extends Event {
    public final List<Integer> seatNumbers;

    public ScreeningSeatsReserved(Long id, List<Integer> seatNumbers) {
        super(id);
        this.seatNumbers = seatNumbers;
    }

}
