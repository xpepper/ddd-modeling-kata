package com.cinemarcos.domain;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public abstract class AbstractTestFixture {

    protected List<Event> history;
    protected List<Event> publishedEvents = new ArrayList<>();

    public void Given(List<Event> eventsFromStorage) {
        history = eventsFromStorage;
    }

    public abstract void When(Command cmd);

    public void Then_expect(List<Event> expectedPublishedEvents) {

        assertThat(publishedEvents.size(), is(expectedPublishedEvents.size()));

        for (Event event : expectedPublishedEvents) {
            assertThat(publishedEvents, contains(event));
        }
        for (Event event : publishedEvents) {
            assertThat(expectedPublishedEvents, contains(event));
        }
    }
}
