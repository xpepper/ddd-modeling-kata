package com.cinemarcos.domain;

import java.util.List;
import java.util.function.Consumer;

public abstract class Handler {
    protected final List<Event> history;
    protected final Consumer<Event> publisher;

    public Handler(List<Event> history, Consumer<Event> publisher) {
        this.history = history;
        this.publisher = publisher;

    }

    public abstract void handle(Command cmd);

}