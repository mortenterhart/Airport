import java.lang.reflect.Method;

public class ServiceVehicleWasteWaterTank {

    private static ServiceVehicleWasteWaterTank instance = new ServiceVehicleWasteWaterTank();

    public static ServiceVehicleWasteWaterTank getInstance() {
        return instance;
    }

    private int amountWasteWater = 0;
    private int lastWasteWaterAmount;

    public Port port;

    private ServiceVehicleWasteWaterTank(){
        port = new Port();
    }

    public String getVehicleType() {
        return "ServiceVehicle: WasteWaterTank";
    }

    public class Port implements IServiceVehicleWasteWaterTank {

        public int pumpOut(Object wasteWaterTankPort){
            return innerMethodPumpOut(wasteWaterTankPort);
        }

        public void notifyGroundOperations(Object groundOperationCenterPort){
            innerMethodNotifyGroundOperations(groundOperationCenterPort);
        }

    }

    private int innerMethodPumpOut(Object wasteWaterTankPort){
        try {
            Method currentWasteWaterAmount = wasteWaterTankPort.getClass().getDeclaredMethod("add", int.class);
            lastWasteWaterAmount = (Integer) currentWasteWaterAmount.invoke(wasteWaterTankPort, 0);
            Method pumpOut = wasteWaterTankPort.getClass().getDeclaredMethod("pumpOut");
            pumpOut.invoke(wasteWaterTankPort);
            amountWasteWater += lastWasteWaterAmount;
            return lastWasteWaterAmount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void innerMethodNotifyGroundOperations(Object groundOperationCenterPort) {
        try {
            Method notifyGroundOperations = groundOperationCenterPort.getClass().getDeclaredMethod("receive", ServiceVehicleWasteWaterTankReceipt.class);
            notifyGroundOperations.invoke(groundOperationCenterPort, new ServiceVehicleWasteWaterTankReceipt(lastWasteWaterAmount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}