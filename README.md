# DDD modeling katas - Cinemarco's Quality Reservation System (CQRS 😅)

## Practice with finding and coding Value Objects, Entities, Repositories and Aggregates 🎁

### Scenario: Online Reservation

* The user selects the day and the time when he/she would like to see the movie.
* The system lists movies available in the given time interval - title and screening times.
* The user chooses a particular screening.
* The system gives information regarding screening room and available seats.
* The user chooses seats, and gives the name of the person doing the reservation (name and surname).
* The system gives back the total amount to pay and reservation expiration time.

### Additional behaviour

* The system covers multiple cinemas all over Europe with multiple rooms (multiplex).
* Seats can be booked at latest 15 minutes before the screening begins.
* There are three ticket types: adult, student, child with varying prices.
* 3D Movies and D-Box Seats cost extra. For students the price gets percentually reduced.

### Covid-19 bonus round

* There must be at least be a single place left over in a row between two already reserved places.

## Practice with Commands and Command Handlers 📡

### Story #1
A Customer reserves specific seats at a specific screening (for simplicity, assume there exists only one screening for the time being).
If available, the seats should be reserved.

### Story #2
The user will be informed, if not all seats from the reservation are available.

### Story #3
Remove all primitive datatypes from the domain. Use only Value Objects and Entities within the domain

### Story #4
Bonuspoints: Make illegal states unrepresentible

## Switch to Event Sourcing... 🎭

### Story #5
Refactor the previous test so that the commandhandlers use EventSourcing as a persistance mechanism.
Publish the Events and test purely with Events and Commands, no dependency on domain state in your tests is allowed.

![](https://i.imgur.com/ef8qTlf.png)

### Story #6
When a second customer tries to reserve already reserved seats, the system treats them as unavailable.

### Story #7
Reservation is only possible up to 15 minutes before the screening.

## Event Sourcing and CQRS
The customer wants to see the available seats of the screening, chooses from the list which ones to reserve and gets informed about success or failure of the reservation.
The reservation is only possible up to 15 minutes before the screening.

### Story #8
Write two tests to ensure each business rule from the scenario by only using commands and events in your test.

### Story #9
Build a read model that supports the user with the required information.
Write a test to ensure that, given the past events, when a query is issued, the expected response is delivered.

![](https://i.imgur.com/GZR4JS8.png)

### Story #10
Write an integration test that uses only commands and queries, no events to check the whole business behaviour of the system.

### Story #11
If no booking happens within 12 minutes, the reservation is canceled.

### Story #12
Implement a way to send a notification to customers.

