package event.boarding_control;

import base.PassengerList;

public class BoardingControlCallPassengers {
    private PassengerList passengers;

    public BoardingControlCallPassengers(PassengerList passengers) {
        this.passengers = passengers;
    }

    public PassengerList getPassengers() {
        return passengers;
    }
}
