# TODO
* create the Screening ID when applying the `ScreeningCreated` event
  * [Question] l'ID dell'aggregato nasce lato client o è server-side? ovvero: nella creazione degli aggregati passate anche l'ID dell'aggregato nel comando o lasciate che venga generato nel costruttore?
* should we fire a `ReservationDenied` event?

* Introduce an event store (as a dependency to the command handler) to read the events to give to `Screening.from(event)` (we have to get the events from somewhere)
* `Screening#researveSeats` has to fire a `ScreeningSeatsReserved` (e.g. `eventstore.publish(event)`)
* Event store has to store the events

### Nice to have
* add a scheduleTime to com.cinemarcos.domain.Screening (we forgot to add it before...)

# Questions
* who fires the `ScreeningCreated` event?
* it's better to have `new Screening(events)` or `Screening.from(events)` to reconstitute a `Screening` from events?

# Ideas
* mechanics of an event sourced architecture
* extract an axon-like library 
* focus on the domain modeling 
  * maybe on a payment domain like an ACS2?
  * using axon to reduce the technical "friction" on the mechanics of ES and CQRS