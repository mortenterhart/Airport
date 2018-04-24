package event.service_vehicle_fresh_water;

public class ServiceVehicleFreshWaterNotifyGroundOperations {
    private String phase;
    private Object groundOperationCenterPort;

    public ServiceVehicleFreshWaterNotifyGroundOperations(String phase, Object groundOperationCenterPort) {
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
        return "event - " + phase + " : ServiceVehicleFreshWaterNotifyGroundOperations";
    }
}
