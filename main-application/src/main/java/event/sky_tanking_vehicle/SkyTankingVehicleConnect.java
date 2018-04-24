package event.sky_tanking_vehicle;

import base.Airplane;

public class SkyTankingVehicleConnect {
    private Airplane airplane;
    private String phase;


    public SkyTankingVehicleConnect(String phase, Airplane airplane) {
        this.airplane = airplane;
        this.phase = phase;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : SkyTankingVehicleConnect";
    }

}
