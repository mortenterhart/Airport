import dummy.PotableWaterTank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceVehicleFreshWaterTest {

    private ServiceVehicleFreshWater.Port serviceVehicleFreshWaterPort = ServiceVehicleFreshWater.getInstance().port;

    @Test
    public void testRefill() {
        PotableWaterTank.Port potableWaterTankPort = PotableWaterTank.getInstance().port;
        potableWaterTankPort.refill();
        potableWaterTankPort.takeOut(200);
        assertEquals(200, serviceVehicleFreshWaterPort.refill(potableWaterTankPort));
    }

}
