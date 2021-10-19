# TODO
* Event store has to store the events

* should we fire a `ReservationDenied` event?


### Nice to have
* add a scheduleTime to com.cinemarcos.domain.Screening (we forgot to add it before...)

# Questions
* l'ID dell'aggregato nasce lato client o è server-side? ovvero: nella creazione degli aggregati passate anche l'ID dell'aggregato nel comando o lasciate che venga generato nel costruttore?
* who fires the `ScreeningCreated` event?
* it's better to have `new Screening(events)` or `Screening.from(events)` to reconstitute a `Screening` from events?

# Ideas
* mechanics of an event sourced architecture
* extract an axon-like library 
* focus on the domain modeling 
  * maybe on a payment domain like an ACS2?
  * using axon to reduce the technical "friction" on the mechanics of ES and CQRS