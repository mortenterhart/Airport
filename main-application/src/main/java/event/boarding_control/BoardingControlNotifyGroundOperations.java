package event.boarding_control;

import base.PassengerList;

public class BoardingControlNotifyGroundOperations {
    private PassengerList passengers;
    private Object groundOperationsPort;

    public BoardingControlNotifyGroundOperations(PassengerList passengers, Object groundOperationsPort) {
        this.passengers = passengers;
        this.groundOperationsPort = groundOperationsPort;
    }

    public PassengerList getPassengers() {
        return passengers;
    }

    public Object getGroundOperationsPort() {
        return groundOperationsPort;
    }
}
