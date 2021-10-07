package com.cinemarcos.domain.valueobject;

import java.time.LocalDateTime;

public class TimeInterval extends ValueObject {
    public final LocalDateTime starting;
    public final LocalDateTime ending;

    private TimeInterval(LocalDateTime starting, LocalDateTime ending) {
        this.starting = starting;
        this.ending = ending;
    }

    public static TimeInterval between(LocalDateTime starting, LocalDateTime ending) {
        return new TimeInterval(starting, ending);
    }
}
