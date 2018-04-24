
interface IServiceVehicleOil {

    int increaseLevelOfAPUOilTank(Object apuOilTankPort);
    int increaseLevelOfEngineOilTank(Object engineOilTankPort);
    boolean change(Object fireExtinguisherPort);
    int refill(Object deIcingSystemPort);
    void notifyGroundOperations(Object groundOperationCenterPort);

}