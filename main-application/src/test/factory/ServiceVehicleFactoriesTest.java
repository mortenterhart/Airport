package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ServiceVehicleFactoriesTest {

    private Object componentPort;

    @Test
    public void testBuildFreshWater() {
        componentPort = ServiceVehicleFreshWaterFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testBuildNitrogenOxygen() {
        componentPort = ServiceVehicleNitrogenOxygenFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testBuildOil() {
        componentPort = ServiceVehicleOilFactory.build();
        assertNotNull(componentPort);
    }

    @Test
    public void testBuildWasteWater() {
        componentPort = ServiceVehicleWasteWaterTankFactory.build();
        assertNotNull(componentPort);
    }

}
