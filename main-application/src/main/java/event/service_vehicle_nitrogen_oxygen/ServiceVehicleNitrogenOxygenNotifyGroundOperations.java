package event.service_vehicle_nitrogen_oxygen;

public class ServiceVehicleNitrogenOxygenNotifyGroundOperations {
    private String phase;
    private Object groundOperationCenterPort;

    public ServiceVehicleNitrogenOxygenNotifyGroundOperations(String phase, Object groundOperationCenterPort) {
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
        return "event - " + phase + " : ServiceVehicleNitrogenOxygenNotifyGroundOperations";
    }
}
