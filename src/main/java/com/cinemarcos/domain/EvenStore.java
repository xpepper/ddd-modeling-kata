package com.cinemarcos.domain;

import java.util.List;

public interface EvenStore {
    List<Event> allEventsById(Long id);

    void append(Event event);
}
