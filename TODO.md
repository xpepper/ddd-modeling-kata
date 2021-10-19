# TODO
* use the java 17 switch case instead of using instanceOf 

### Nice to have
* add a scheduleTime to Screening (we forgot to add it before...)

# Questions
* the aggregate ID (e.g. `Screening`) should be defined client side (and thus be passed in and received as a parameter of a command) or on the "server-side", generated somehow by the aggregate itself?
* who fires the `ScreeningCreated` event?
* should we fire a `ReservationDenied` event?
* it's better to have `new Screening(events)` or `Screening.from(events)` to reconstitute a `Screening` from events?
* trade-offs between using an interface (`Publisher#publish(event)`) vs passing a function (`(event) -> EventStore::append`)

# Ideas
* mechanics of an event sourced architecture
* extract an axon-like library 
* focus on the domain modeling 
  * maybe on a payment domain like an ACS2?
  * using axon to reduce the technical "friction" on the mechanics of ES and CQRS