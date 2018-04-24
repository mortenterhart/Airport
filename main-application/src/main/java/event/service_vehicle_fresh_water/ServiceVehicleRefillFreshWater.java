package event.service_vehicle_fresh_water;

import base.Airplane;

public class ServiceVehicleRefillFreshWater {
    private String phase;
    private Airplane airplane;

    public ServiceVehicleRefillFreshWater(String phase, Airplane airplane) {
        this.phase = phase;
        this.airplane = airplane;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleRefillFreshWater";
    }
}
