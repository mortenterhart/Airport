import java.lang.reflect.Method;

public class ServiceVehicleNitrogenOxygen {

    private static ServiceVehicleNitrogenOxygen instance = new ServiceVehicleNitrogenOxygen();

    public static ServiceVehicleNitrogenOxygen getInstance() {
        return instance;
    }

    private int amountNitrogen = 1000;
    private int amountOxygen = 1000;
    private int lastRefillNitrogenAmount;
    private int lastRefillOxygenAmount;

    public Port port;

    private ServiceVehicleNitrogenOxygen(){
        port = new Port();
    }

    public String getVehicleType() {
        return "ServiceVehicle: NitrogenOxygen";
    }

    public class Port implements IServiceVehicleNitrogenOxygen {

        public int refillNitrogenBottle(Object nitrogenBottlePort) {
            return innerMethodRefillNitrogenBottle(nitrogenBottlePort);
        }

        public int refillOxygenBottle(Object oxygenBottlePort) {
            return innerMethodRefillOxygenBottle(oxygenBottlePort);
        }

        public void notifyGroundOperations(Object groundOperationCenterPort) {
            innerMethodNotifyGroundOperations(groundOperationCenterPort);
        }

    }

    private int innerMethodRefillNitrogenBottle(Object nitrogenBottlePort) {
        try {
            Method refillNitrogen = nitrogenBottlePort.getClass().getDeclaredMethod("refill", int.class);
            int currentValue = (Integer) refillNitrogen.invoke(nitrogenBottlePort, 0);
            lastRefillNitrogenAmount = (Integer) refillNitrogen.invoke(nitrogenBottlePort, 250 - currentValue) - currentValue;
            amountNitrogen -= lastRefillNitrogenAmount;
            return lastRefillNitrogenAmount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int innerMethodRefillOxygenBottle(Object oxygenBottlePort) {
        try {
            Method refillOxygen = oxygenBottlePort.getClass().getDeclaredMethod("refill", int.class);
            int currentValue = (Integer) refillOxygen.invoke(oxygenBottlePort, 0);
            lastRefillOxygenAmount = (Integer) refillOxygen.invoke(oxygenBottlePort, 100 - currentValue) - currentValue;
            amountOxygen -= currentValue;
            return lastRefillOxygenAmount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void innerMethodNotifyGroundOperations(Object groundOperationCenterPort) {
        try {
            Method notifyGroundOperations = groundOperationCenterPort.getClass().getDeclaredMethod("receive", ServiceVehicleNitrogenOxygenReceipt.class);
            notifyGroundOperations.invoke(groundOperationCenterPort, new ServiceVehicleNitrogenOxygenReceipt(lastRefillNitrogenAmount, lastRefillOxygenAmount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}