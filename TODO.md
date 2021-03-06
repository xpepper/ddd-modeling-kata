# TODO

### Story #1
A Customer reserves specific seats at a specific screening (for simplicity, assume there exists only one screening for the time being).
If available, the seats should be reserved.

### Nice to have
* add a scheduleTime to Screening (we forgot to add it before...)
* use the java 17 (preview) switch case instead of using instanceOf

# Questions
* the aggregate ID (e.g. `Screening`) should be defined client side (and thus be passed in and received as a parameter of a command) or on the "server-side", generated somehow by the aggregate itself?
* who fires the `ScreeningCreated` event?
  * we imagined a `ScreeningCreated` event that is needed in order to define a screening (its seats, its schedule maybe, etc)… This event - I guess - is fired by the aggregate after reacting to the command that create a `Screening` (e.g. `CreateScreeningCommand` ). Is it reasonable?
* should we fire a `ReservationDenied` event when the seats are not available?
* it's better to have `new Screening(events)` or `Screening.from(events)` to reconstitute a `Screening` from events?
* trade-offs between using an interface (`Publisher#publish(event)`) vs passing a function (`(event) -> EventStore::append`)

# Ideas
* mechanics of an event sourced architecture
* extract an axon-like library 
* focus on the domain modeling 
  * maybe on a payment domain like an ACS2?
  * using axon to reduce the technical "friction" on the mechanics of ES and CQRS