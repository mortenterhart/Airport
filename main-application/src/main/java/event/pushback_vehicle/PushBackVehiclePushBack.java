package event.pushback_vehicle;

import base.Airplane;

public class PushBackVehiclePushBack {

    private Airplane airplane;
    private String phase;

    public PushBackVehiclePushBack(String phase, Airplane airplane) {
        this.airplane = airplane;
        this.phase = phase;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() { return phase; }

    public String toString() {
        return "event - " + phase + " : PushBackVehiclePushBack";
    }
}
