package event.service_vehicle_oil;

import base.Airplane;

public class ServiceVehicleRefillDeIcingSystem {
    private String phase;
    private Airplane airplane;

    public ServiceVehicleRefillDeIcingSystem(String phase, Airplane airplane) {
        this.phase = phase;
        this.airplane = airplane;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleRefillDeIcingSystem";
    }
}
