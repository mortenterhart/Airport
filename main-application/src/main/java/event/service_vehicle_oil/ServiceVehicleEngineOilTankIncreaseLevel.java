package event.service_vehicle_oil;

import base.Airplane;

public class ServiceVehicleEngineOilTankIncreaseLevel {
    private String phase;
    private Airplane airplane;

    public ServiceVehicleEngineOilTankIncreaseLevel(String phase, Airplane airplane) {
        this.phase = phase;
        this.airplane = airplane;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleEngineOilTankIncreaseLevel";
    }
}
