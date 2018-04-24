package event.service_vehicle_oil;

public class ServiceVehicleOilNotifyGroundOperations {
    private String phase;
    private Object groundOperationCenterPort;

    public ServiceVehicleOilNotifyGroundOperations(String phase, Object groundOperationCenterPort) {
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
        return "event - " + phase + " : ServiceVehicleOilNotifyGroundOperations";
    }
}
