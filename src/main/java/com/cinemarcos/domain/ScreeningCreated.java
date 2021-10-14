package com.cinemarcos.domain;

import java.util.List;

public class ScreeningCreated extends Event {
    public final List<Integer> seats;

    public ScreeningCreated(Long id, List<Integer> seats) {
        super(id);
        this.seats = seats;
    }
}
