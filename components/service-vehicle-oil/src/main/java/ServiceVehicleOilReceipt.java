public class ServiceVehicleOilReceipt {

    private int amountAPUOil;
    private int amountEngineOil;

    public ServiceVehicleOilReceipt(int amountAPUOil, int amountEngineOil) {
        this.amountAPUOil = amountAPUOil;
        this.amountEngineOil = amountEngineOil;
    }

    public int getAmountAPUOil() {
        return amountAPUOil;
    }

    public int getAmountEngineOil() {
        return amountEngineOil;
    }

}
