import dummy.APUOilTank;
import dummy.DeIcingSystem;
import dummy.EngineOilTank;
import dummy.FireExtinguisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceVehicleOilTest {

    private ServiceVehicleOil.Port serviceVehicleOilPort = ServiceVehicleOil.getInstance().port;

    @Test
    public void testIncreaseLevelOfAPUOilTank() {
        APUOilTank.Port apuOilTankPort = APUOilTank.getInstance().port;
        apuOilTankPort.decreaseLevel(2);
        assertEquals(2, serviceVehicleOilPort.increaseLevelOfAPUOilTank(apuOilTankPort));
    }

    @Test
    public void testIncreaseLevelOfEngineOilTank() {
        EngineOilTank.Port engineOilTankPort = EngineOilTank.getInstance().port;
        engineOilTankPort.decreaseLevel(2);
        assertEquals(2, serviceVehicleOilPort.increaseLevelOfEngineOilTank(engineOilTankPort));

    }

    @Test
    public void testChange() {
        FireExtinguisher.Port fireExtinguisherPort = FireExtinguisher.getInstance().port;
        assertTrue(serviceVehicleOilPort.change(fireExtinguisherPort));
    }

    @Test
    public void testRefill() {
        DeIcingSystem.Port deIcingSystemPort = DeIcingSystem.getInstance().port;
        deIcingSystemPort.deIce(100);
        assertEquals(100, serviceVehicleOilPort.refill(deIcingSystemPort));
    }

}
