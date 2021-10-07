package com.cinemarcos.domain.valueobject;

import java.time.LocalDateTime;
import java.time.Month;

public class ScreeningTime extends ValueObject {
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

    public static ScreeningTime at(int year, Month month, int dayOfMonth, int hour, int minute) {
        return new ScreeningTime(LocalDateTime.of(year, month, dayOfMonth, hour, minute));
    }

    public LocalDateTime startingTime() {
        return starting;
    }

    public boolean isIn(TimeInterval timeInterval) {
        return starting.isAfter(timeInterval.starting) && starting.isBefore(timeInterval.ending);
    }
}
