import java.lang.reflect.Method;

public class ServiceVehicleFreshWater {

    private int amountFreshWater = 5000;
    private int lastRefillAmount;

    private static ServiceVehicleFreshWater instance = new ServiceVehicleFreshWater();

    public static ServiceVehicleFreshWater getInstance() {
        return instance;
    }

    public Port port;

    private ServiceVehicleFreshWater() {
        port = new Port();
    }

    public String getVehicleType() {
        return "ServiceVehicle: FreshWater";
    }

    public class Port implements IServiceVehicleFreshWater {

        public int refill(Object potableWaterTankPort) {
            return innerMethodRefill(potableWaterTankPort);
        }

        public void notifyGroundOperations(Object groundOperationCenterPort) {
            innerMethodNotifyGroundOperations(groundOperationCenterPort);
        }

    }

    private int innerMethodRefill(Object potableWaterTankPort) {
        try {
            Method refillFreshWater = potableWaterTankPort.getClass().getDeclaredMethod("refill", int.class);
            int currentValue = (Integer) refillFreshWater.invoke(potableWaterTankPort, 0);
            lastRefillAmount = (Integer) refillFreshWater.invoke(potableWaterTankPort, 1000 - currentValue) - currentValue;
            amountFreshWater -= currentValue;
            return lastRefillAmount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void innerMethodNotifyGroundOperations(Object groundOperationCenterPort) {
        try {
            Method notifyGroundOperations = groundOperationCenterPort.getClass().getDeclaredMethod("receive", ServiceVehicleFreshWaterReceipt.class);
            notifyGroundOperations.invoke(groundOperationCenterPort, new ServiceVehicleFreshWaterReceipt(lastRefillAmount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}