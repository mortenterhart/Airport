import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BaggageVehicleUnitTest {
    @Test
    public void storeTest(){
        BaggageVehicle baggageVehicle = new BaggageVehicle();
        Container container = new Container(null,null,null,null,null,null,50);
        Assertions.assertEquals(1,baggageVehicle.innerStore(container));

    }
}
