# DDD modeling kata - Cinemarco's Quality Reservation System (CQRS)

## Scenario: Online Reservation

* The user selects the day and the time when he/she would like to see the movie.
* The system lists movies available in the given time interval - title and screening times.
* The user chooses a particular screening.
* The system gives information regarding screening room and available seats.
* The user chooses seats, and gives the name of the person doing the reservation (name and surname).
* The system gives back the total amount to pay and reservation expiration time.

## Additional behaviour

* The system covers multiple cinemas all over Europe with multiple rooms (multiplex).
* Seats can be booked at latest 15 minutes before the screening begins.
* There are three ticket types: adult, student, child with varying prices.
* 3D Movies and D-Box Seats cost extra. For students the price gets percentually reduced.

## Covid-19 bonus round

* There must be at least be a single place left over in a row between two already reserved places.