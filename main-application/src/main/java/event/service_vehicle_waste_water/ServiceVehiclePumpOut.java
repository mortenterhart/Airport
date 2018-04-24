package event.service_vehicle_waste_water;

import base.Airplane;

public class ServiceVehiclePumpOut {
    private String phase;
    private Airplane airplane;

    public ServiceVehiclePumpOut(String phase, Airplane airplane) {
        this.phase = phase;
        this.airplane = airplane;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehiclePumpOut";
    }
}
