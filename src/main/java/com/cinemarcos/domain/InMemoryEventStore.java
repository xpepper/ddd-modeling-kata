package com.cinemarcos.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEventStore implements EvenStore {
    private final Map<Long, List<Event>> store = new HashMap<>();

    @Override public List<Event> allEventsById(Long id) {
        return store.getOrDefault(id, new ArrayList<>());
    }

    @Override public void append(Event event) {
        if (store.containsKey(event.id)) {
            List<Event> events = store.get(event.id);
            events.add(event);
            store.put(event.id, events);
        } else {
            List<Event> events = new ArrayList<>();
            events.add(event);
            store.put(event.id, events);
        }
    }
}
