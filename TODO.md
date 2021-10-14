# TODO
* Introduce an event store (as a dependency to the command handler) to read the events to give to `Screening.from(event)` (we have to get the events from somewhere)
* `Screening#researveSeats` has to fire a `ScreeningSeatsReserved` (e.g. `eventstore.publish(event)`)
* Event store has to store the events

### Nice to have
* add a scheduleTime to com.cinemarcos.domain.Screening (we forgot to add it before...)

# Questions
* who fires the `ScreeningCreated` event?
* it's better to have `new Screening(events)` or `Screening.from(events)` to reconstitute a `Screening` from events?
