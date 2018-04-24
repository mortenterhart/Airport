package event.service_vehicle_waste_water;

public class ServiceVehicleWasteWaterNotifyGroundOperations {
    private String phase;
    private Object groundOperationCenterPort;

    public ServiceVehicleWasteWaterNotifyGroundOperations(String phase, Object groundOperationCenterPort) {
        this.phase = phase;
        this.groundOperationCenterPort = groundOperationCenterPort;
    }

    public Object getGroundOperationCenterPort() {
        return groundOperationCenterPort;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ServiceVehicleWasteWaterNotifyGroundOperations";
    }
}
