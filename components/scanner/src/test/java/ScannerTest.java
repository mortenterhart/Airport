import base.Baggage;
import base.BaggageType;
import base.Passenger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ScannerTest {
    @Test
    public void Scanner_Baggage_Found(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        Baggage bag = new Baggage("TestStringGlockEnde", 1, BaggageType.Normal);

        Assert.assertTrue("Scanner should find the pattern", port.scan(bag, "Glock"));
    }

    @Test
    public void Scanner_Baggage_NothingFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        Baggage bag = new Baggage("TestStringEnde", 1, BaggageType.Normal);

        Assert.assertFalse("Scanner should find nothing", port.scan(bag, "Glock"));
    }

    @Test
    public void Scanner_Passenger_InContentFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        ArrayList<Baggage> baggages = new ArrayList<Baggage>();
        baggages.add(new Baggage("TestStringEnde", 1, BaggageType.Normal));
        baggages.add(new Baggage("StringTest", 1, BaggageType.Normal));
        Passenger passenger = createTestPassenger("Mario Glock", baggages);

        Assert.assertTrue("Scanner should find nothing", port.scan(passenger, "Glock"));
    }
    @Test
    public void Scanner_Passenger_InBaggageFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        ArrayList<Baggage> baggages = new ArrayList<Baggage>();
        baggages.add(new Baggage("TestStringEnde", 1, BaggageType.Normal));
        baggages.add(new Baggage("StringGLOCKTest", 1, BaggageType.Normal));
        Passenger passenger = createTestPassenger("Mario Test", baggages);

        Assert.assertTrue("Scanner should find nothing", port.scan(passenger, "Glock"));
    }

    @Test
    public void Scanner_Passenger_NothingFound(){
        Scanner scanner = Scanner.getInstance();
        Scanner.Port port = scanner.port;

        ArrayList<Baggage> baggages = new ArrayList<Baggage>();
        baggages.add(new Baggage("TestStringEnde", 1, BaggageType.Normal));
        baggages.add(new Baggage("StringTest", 1, BaggageType.Normal));
        Passenger passenger = createTestPassenger("Mario Test", baggages);


        Assert.assertFalse("Scanner should find nothing", port.scan(passenger, "Glock"));
    }

    private Passenger createTestPassenger(String content, ArrayList<Baggage> baggages) {
        return new Passenger(null, content, null, null, null, null, null, null, null, baggages, null);
    }
}
