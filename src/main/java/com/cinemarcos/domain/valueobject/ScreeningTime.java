package com.cinemarcos.domain.valueobject;

import java.time.LocalDateTime;

public class ScreeningTime {
    private final LocalDateTime starting;

    private ScreeningTime(LocalDateTime starting) {
        this.starting = starting;
    }

    public static ScreeningTime from(LocalDateTime startTime) {
        return new ScreeningTime(
                LocalDateTime.of(
                        startTime.getYear(),
                        startTime.getMonth(),
                        startTime.getDayOfMonth(),
                        startTime.getHour(),
                        startTime.getMinute()
                ));
    }

    public LocalDateTime startingTime() {
        return starting;
    }
}
