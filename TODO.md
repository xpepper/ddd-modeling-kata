# TODO
* Add an ID to the `Screening` aggregate to be able to retrieve from the event store only its events
* Introduce an event store (as a dependency to the command handler) to read the events to give to `Screening.from(event)` (we have to get the events from somewhere)
* `Screening#researveSeats` has to fire a `ScreeningSeatsReserved` (e.g. `eventstore.publish(event)`)
* Event store has to store the events

### Nice to have
* add a scheduleTime to com.cinemarcos.domain.Screening (we forgot to add it before...)

# Questions
* who fires the `ScreeningCreated` event?
