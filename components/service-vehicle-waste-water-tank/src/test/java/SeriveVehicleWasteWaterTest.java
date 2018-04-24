import dummy.WasteWaterTank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeriveVehicleWasteWaterTest {

    private ServiceVehicleWasteWaterTank.Port serviceVehicleWasteWaterTankPort = ServiceVehicleWasteWaterTank.getInstance().port;

    @Test
    public void testPumpOut() {
        WasteWaterTank.Port wasteWaterTankPort = WasteWaterTank.getInstance().port;
        wasteWaterTankPort.add(300);
        assertEquals(300, serviceVehicleWasteWaterTankPort.pumpOut(wasteWaterTankPort));
    }

}
