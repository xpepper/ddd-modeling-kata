package com.cinemarcos.domain;

import com.cinemarcos.domain.valueobject.Screening;
import com.cinemarcos.domain.valueobject.TimeInterval;
import com.cinemarcos.domain.valueobject.User;
import com.cinemarcos.domain.valueobject.Username;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Application {
    public static void main(String[] args) {
        OnlineReservation reservation = new OnlineReservation();

        LocalDateTime starting = LocalDateTime.now();
        LocalDateTime ending = LocalDateTime.now().plusDays(1);

        TimeInterval timeInterval = TimeInterval.between(starting, ending);

        List<Screening> availableScreenings = reservation.availableMoviesAt(timeInterval);

        User user = new User(UUID.randomUUID(), new Username("pietro.dibello"));

    }

}
