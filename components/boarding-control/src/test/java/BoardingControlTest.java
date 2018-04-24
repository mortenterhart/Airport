import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardingControlTest {
    private BoardingControl.Port boardingControlPort;
    private PassengerList passengerList;

    @Before
    public void init() {
        BoardingControl boardingControl = BoardingControl.getInstance();
        boardingControlPort = boardingControl.port;

        passengerList = new PassengerList(new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            passengerList.getPassengerList().add(new Passenger("Max Mustermann", "content", "04.01.1995",
                    "Example Street", "74821", "Mosbach", CitizenshipCode.DEU, Gender.Female,
                    null, null, null));
        }
    }

    @Test
    public void testGetInstance() {
        assertNotNull(BoardingControl.getInstance());
    }

    @Test
    public void testCallPassengers() {
        boardingControlPort.printPassengerList(passengerList);
    }

    @Test
    public void testInspectPassport() {
        assertTrue(boardingControlPort.inspect(new Passport("1", "/path/to/picture.png", "DEU", null)));
    }

    @Test
    public void testScanBoardingPass() {
        assertTrue(boardingControlPort.scan(new BoardingPass("1", Carrier.Lufthansa, "NH380", null, null,
                Source.MUC, Destination.CPT, "01.04.1998", "B4", "13:14", "6F")));
    }

    @Test
    public void testPrintPassengersList() {
        boardingControlPort.printPassengerList(passengerList);
    }
}
