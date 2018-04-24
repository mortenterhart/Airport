package event.sky_tanking_vehicle;
import base.Airplane;

public class SkyTankingVehiclePrint {
    private Airplane airplane;
    private String phase;

    public SkyTankingVehiclePrint(String phase, Airplane airplane) {
        this.airplane = airplane;
        this.phase = phase;
    }

    public Airplane getAirplane() { return airplane; }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : SykTankingVehiclePrint";
    }

}
