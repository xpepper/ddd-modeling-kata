package com.cinemarcos.domain;

import java.util.List;

public class ScreeningCreated extends Event {
    public final List<Integer> seats;

    public ScreeningCreated(List<Integer> seats) {
        this.seats = seats;
    }
}
