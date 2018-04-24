import base.Baggage;
import base.BaggageType;
import base.Passenger;
import event.security_check.SecurityCheck;
import org.junit.Test;

import java.util.ArrayList;

public class SecurityCheckUnitTest {
    @Test
    public void SecurityCheckUnitTest__AirportReceive() {
        SecurityCheck securityCheck = new SecurityCheck(this.getTestPassengerTestData("glock7"), this.getTestBaggageTestData(0, 45));

        Airport airport = new Airport();
        airport.build();

        airport.receive(securityCheck);
    }

    private ArrayList<Passenger> getTestPassengerTestData(String content) {
        ArrayList<Passenger> list = new ArrayList<>();
        for(int i=0; i<10; i++)
            list.add(new Passenger(null, content, null, null, null, null, null, null, null, this.getTestBaggageTestData(0, 45), null));
        return list;
    }

    private ArrayList<Baggage> getTestBaggageTestData(int offset, int count) {
        ArrayList<Baggage> list = new ArrayList<Baggage>();

        for (int i = 0 + offset; i < count + offset; i++) {
            list.add(new Baggage( "" + i, 1.0, BaggageType.Normal));
        }

        return list;
    }
}
