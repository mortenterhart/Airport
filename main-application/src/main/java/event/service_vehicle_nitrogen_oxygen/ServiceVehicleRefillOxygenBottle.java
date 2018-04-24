package event.service_vehicle_nitrogen_oxygen;

import base.Airplane;

public class ServiceVehicleRefillOxygenBottle {
    private String phase;
    private Airplane airplane;

    public ServiceVehicleRefillOxygenBottle(String phase, Airplane airplane) {
        this.phase = phase;
        this.airplane = airplane;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleRefillOxygenBottle";
    }
}
