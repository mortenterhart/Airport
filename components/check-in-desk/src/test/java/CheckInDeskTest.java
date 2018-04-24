import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CheckInDeskTest {

    @Test
    public void checkInTest(){
        Baggage baggage = new Baggage(
                "1",
                2,
                BaggageType.Normal
        );

        Passenger passenger = new Passenger(
                "Müller",
                null,
                "01.01.2000",
                "mainstreet",
                "123",
                "NY",
                CitizenshipCode.USA,
                Gender.Male,
                null,
                null,
                null
        );

        CheckInDesk checkInDesk = CheckInDesk.getInstance();
        checkInDesk.setBoardingTime("1");
        checkInDesk.setDate("2");
        checkInDesk.setDestination(Destination.DXB);
        checkInDesk.setFlight("4");
        checkInDesk.setGate("5");
        checkInDesk.setNumberOfPassengersFirstClass(1);

        BoardingPass expectedBoardingPass = new BoardingPass(
                null,
                null,
                checkInDesk.getFlight(),
                passenger,
                TicketClass.First,
                checkInDesk.getSource(),
                Destination.DXB,
                checkInDesk.getDate(),
                checkInDesk.getGate(),
                checkInDesk.getBoardingTime(),
                null);
        ArrayList<Baggage> listBaggage = new ArrayList<Baggage>();
        listBaggage.add(baggage);
        BoardingPass result;
        result = checkInDesk.innerCheckIn(passenger, listBaggage);
        assertEquals(expectedBoardingPass.getGate(), result.getGate());
        assertEquals(expectedBoardingPass.getPassenger(), result.getPassenger());
        assertEquals(expectedBoardingPass.getTicketClass(), result.getTicketClass());
        assertEquals(passenger.getBaggageList(), listBaggage);
    }

    @Test
    public void scan1(){
        Passport passport = new Passport("1", "pic", "N/A", null);
        CheckInDesk checkInDesk = CheckInDesk.getInstance();
        boolean result = checkInDesk.innerScan(passport);
        assertEquals(true, result);
    }

    @Test
    public void checkInTest1(){
        Baggage baggage = new Baggage("1", 2, BaggageType.Normal);
        BaggageIdentificationTag baggageIdentificationTag = new BaggageIdentificationTag(
                UUID.randomUUID().toString(),
                null,
                null,
                1,
                "N/A",
                "N/A",
                "N/A",
                baggage,
                null,
                true,
                true,
                true,
                UUID.randomUUID().toString()
        );
        CheckInDesk checkInDesk = CheckInDesk.getInstance();
        BaggageIdentificationTag result = checkInDesk.innerCheckIn(baggage);
        assertEquals(baggageIdentificationTag.getBaggage(), result.getBaggage());
    }
}
