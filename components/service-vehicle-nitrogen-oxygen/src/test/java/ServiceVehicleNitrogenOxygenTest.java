import dummy.NitrogenBottle;
import dummy.OxygenBottle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceVehicleNitrogenOxygenTest {

    private ServiceVehicleNitrogenOxygen.Port serviceVehicleNitrogenOxygenPort = ServiceVehicleNitrogenOxygen.getInstance().port;

    @Test
    public void testRefillNitrogenBottle() {
        NitrogenBottle.Port nitrogenBottlePort = NitrogenBottle.getInstance().port;
        nitrogenBottlePort.refill();
        nitrogenBottlePort.takeOut(50);
        assertEquals(50, serviceVehicleNitrogenOxygenPort.refillNitrogenBottle(nitrogenBottlePort));
    }

    @Test
    public void testRefillOxygenBottle() {
        OxygenBottle.Port oxygenBottlePort = OxygenBottle.getInstance().port;
        oxygenBottlePort.refill();
        oxygenBottlePort.takeOut(20);
        assertEquals(20, serviceVehicleNitrogenOxygenPort.refillOxygenBottle(oxygenBottlePort));
    }

}
