package com.cinemarcos.domain;

import java.util.List;

public class ReserveSeatsCommand {
    public final Long screeningId;
    public final List<Integer> seats;

    public ReserveSeatsCommand(Long screeningId, List<Integer> seats) {
        this.screeningId = screeningId;
        this.seats = seats;
    }
}
