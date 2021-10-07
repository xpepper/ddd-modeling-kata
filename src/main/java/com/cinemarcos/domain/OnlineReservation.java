package com.cinemarcos.domain;

import com.cinemarcos.domain.valueobject.Movie;
import com.cinemarcos.domain.valueobject.Screening;
import com.cinemarcos.domain.valueobject.ScreeningTime;
import com.cinemarcos.domain.valueobject.TimeInterval;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class OnlineReservation {
    private static final List<Screening> screenings = Arrays.asList(
            new Screening(new Movie("Free Guy"), Arrays.asList(ScreeningTime.at(2021, Month.OCTOBER, 21, 19, 30))),
            new Screening(new Movie("The Fall"), asList(ScreeningTime.at(2021, Month.OCTOBER, 22, 19, 30)))
    );

    public List<Screening> availableMoviesAt(TimeInterval timeInterval) {
        return screenings.stream()
                .filter(screening -> screening.startsIn(timeInterval))
                .collect(Collectors.toList());
    }
}
