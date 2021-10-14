package com.cinemarcos.domain;

import java.util.List;

public class ScreeningCreated extends Event {
    public Long id;
    public final List<Integer> seats;

    public ScreeningCreated(Long id, List<Integer> seats) {
        this.id = id;
        this.seats = seats;
    }
}
