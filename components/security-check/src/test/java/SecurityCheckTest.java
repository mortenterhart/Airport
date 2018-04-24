import base.Baggage;
import base.BaggageType;
import base.Passenger;
import base.SecurityCheckReceipt;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SecurityCheckTest {
    @Test
    public void SecurityCheck_BaggageFound() {
        SecurityCheck securityCheck = SecurityCheck.getInstance();
        SecurityCheck.Port port = securityCheck.port;

        Baggage bag = new Baggage("TestStringGlockEnde", 1, BaggageType.Normal);

        Assert.assertTrue("Scanner should find the pattern", port.scan(bag, new MockScanner(), "Glock"));
        SecurityCheck.resetInstance();
    }

    @Test
    public void SecurityCheck_PassengerFound() {
        SecurityCheck securityCheck = SecurityCheck.getInstance();
        SecurityCheck.Port port = securityCheck.port;

        Passenger passenger = new Passenger(null, "TestStringGlockEnde", null, null, null, null, null, null, null, null, null);

        Assert.assertTrue("Scanner should find the pattern", port.scan(passenger, new MockScanner(), "Glock"));
        SecurityCheck.resetInstance();
    }

    @Test
    public void SecurityCheck_RecipeCreatedForOnePassanger() {
        SecurityCheck securityCheck = SecurityCheck.getInstance();
        SecurityCheck.Port port = securityCheck.port;

        ArrayList<Baggage> baggages = new ArrayList<Baggage>();

        baggages.add(new Baggage("TestStringGlockEnde", 1, BaggageType.Normal));
        baggages.add(new Baggage("asjhjskadhkasjdadsjk", 1, BaggageType.Normal));
        baggages.add(new Baggage("TestStringGlockEnde", 1, BaggageType.Normal));
        baggages.add(new Baggage("fdsfsdfsdfdff", 1, BaggageType.Normal));
        baggages.add(new Baggage("fdsfsdfsdfsd", 1, BaggageType.Normal));
        baggages.add(new Baggage("sfdfsdfdsfsdfsdfsdfsdf", 1, BaggageType.Normal));
        baggages.add(new Baggage("dsfsdfsdfsdfascascas", 1, BaggageType.Normal));

        Passenger passenger = createTestPassenger("ThereIsAWeaponInThisPassengersLuggage", baggages);

        Assert.assertTrue("Scanner should find the pattern", port.scan(passenger, new MockScanner(), "Glock"));

        SecurityCheckReceipt receipt = port.getSecurityCheckReceipt();

        Assert.assertEquals("Should have 7 scanned bags",7, receipt.getNumberOfBaggageScanned());
        Assert.assertEquals("Should have 2 dangerous bags",2, receipt.getNumberOfDangerousBaggage());
        Assert.assertEquals("Should have 1 scanned passenger",1, receipt.getNumberOfPassengerScanned());
        SecurityCheck.resetInstance();
    }

    @Test
    public void SecurityCheck_RecipeCreatedForMorePassangers() {
        SecurityCheck securityCheck = SecurityCheck.getInstance();
        SecurityCheck.Port port = securityCheck.port;

        ArrayList<Baggage> baggages = new ArrayList<Baggage>();
        baggages.add(new Baggage("TestStringGlockEnde", 1, BaggageType.Normal));
        baggages.add(new Baggage("asjhjskadhkasjdadsjk", 1, BaggageType.Normal));
        Passenger passenger1 = createTestPassenger("ThereIsAWeaponInThisPassengersLuggage", baggages);

        baggages = new ArrayList<Baggage>();
        baggages.add(new Baggage("TestStringGlockEnde", 1, BaggageType.Normal));
        baggages.add(new Baggage("fdsfsdfsdfdff", 1, BaggageType.Normal));
        Passenger passenger2 = createTestPassenger("ThereIsAWeaponInThisPassengersLuggage", baggages);

        baggages = new ArrayList<Baggage>();
        baggages.add(new Baggage("fdsfsdfsdfsd", 1, BaggageType.Normal));
        baggages.add(new Baggage("sfdfsdfdsfsdfsdfsdfsdf", 1, BaggageType.Normal));
        Passenger passenger3 = createTestPassenger("ThereIsNoWeaponInThisPassengersLuggage", baggages);

        baggages = new ArrayList<Baggage>();
        baggages.add(new Baggage("dsfsdfsdfsdfascascas", 1, BaggageType.Normal));
        Passenger passenger4 = createTestPassenger("ThereIsNoWeaponInThisPassengersLuggage", baggages);

        Assert.assertTrue("Scanner should find the pattern", port.scan(passenger1, new MockScanner(), "Glock"));
        Assert.assertTrue("Scanner should find the pattern", port.scan(passenger2, new MockScanner(), "Glock"));
        Assert.assertFalse("Scanner shouldn´t find the pattern", port.scan(passenger3, new MockScanner(), "Glock"));
        Assert.assertFalse("Scanner shouldn´t find the pattern", port.scan(passenger4, new MockScanner(), "Glock"));

        SecurityCheckReceipt receipt = port.getSecurityCheckReceipt();

        Assert.assertEquals("Should have 7 scanned bags",7, receipt.getNumberOfBaggageScanned());
        Assert.assertEquals("Should have 2 dangerous bags",2, receipt.getNumberOfDangerousBaggage());
        Assert.assertEquals("Should have 4 scanned passenger",4, receipt.getNumberOfPassengerScanned());
        SecurityCheck.resetInstance();
    }

    private Passenger createTestPassenger(String content, ArrayList<Baggage> baggages) {
        return new Passenger(null, content, null, null, null, null, null, null, null, baggages, null);
    }
}
