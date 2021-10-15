package com.cinemarcos.domain;

import java.util.Set;

public class ReserveSeatsForScreening implements Command {

    public String customerId;
    public Set<Integer> seats;
    public String screeningId;

    public ReserveSeatsForScreening(String customerId, Set<Integer> seats, String screeningId) {
        this.customerId = customerId;
        this.seats = seats;
        this.screeningId = screeningId;
    }
}