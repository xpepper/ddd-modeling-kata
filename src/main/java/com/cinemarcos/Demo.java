package com.cinemarcos;

import com.cinemarcos.domain.*;

import static java.util.Arrays.asList;

public class Demo {
    public static void main(String[] args) {
        ReserveSeatsCommandHandler commandHandler = new ReserveSeatsCommandHandler(new InMemoryScreeningRepository());

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

    private static class InMemoryScreeningRepository implements ScreeningRepository {
        public static Screening SCREENING = new Screening(
                123L,
                Seat.available(1),
                Seat.available(3),
                Seat.available(42),
                Seat.available(45),
                Seat.available(89)
        );

        @Override public Screening byId(Long id) {
            return SCREENING;
        }

        @Override public void save(Screening screening) {
            SCREENING = screening;
            System.out.println("saved screening = " + screening);
        }
    }
}
