package com.cinemarcos.domain.valueobject;

import java.util.List;

public class Screening extends ValueObject {
    private final Movie movie;
    private final List<ScreeningTime> screeningTimes;

    public <Screening> Screening(Movie movie, List<ScreeningTime> screeningTimes) {
        this.movie = movie;
        this.screeningTimes = screeningTimes;
    }

    public boolean startsIn(TimeInterval timeInterval) {
        return screeningTimes.stream().anyMatch( screeningTime -> screeningTime.isIn(timeInterval));
    }
}
