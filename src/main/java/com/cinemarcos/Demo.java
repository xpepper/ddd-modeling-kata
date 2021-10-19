package com.cinemarcos;

import com.cinemarcos.domain.*;

import static java.util.Arrays.asList;

public class Demo {
    public static void main(String[] args) {
        InMemoryEventStore eventStore = new InMemoryEventStore();
        eventStore.append(new ScreeningCreated(123L, asList(1, 3, 42, 45, 89)));

        ReserveSeatsCommandHandler commandHandler = new ReserveSeatsCommandHandler(eventStore);

        Boolean reserved = commandHandler.handle(new ReserveSeatsCommand(123L, asList(1)));
        System.out.println("reserved 1 = " + reserved);

        reserved = commandHandler.handle(new ReserveSeatsCommand(123L, asList(3)));
        System.out.println("reserved 3 = " + reserved);

        reserved = commandHandler.handle(new ReserveSeatsCommand(123L, asList(42, 45)));
        System.out.println("reserved 42,45 = " + reserved);

        reserved = commandHandler.handle(new ReserveSeatsCommand(123L, asList(89, 90)));
        System.out.println("reserved 89,90= " + reserved);

        reserved = commandHandler.handle(new ReserveSeatsCommand(123L, asList(1)));
        System.out.println("reserved 1 = " + reserved);
    }
}
