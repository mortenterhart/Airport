import base.*;
import base.BoardingPass;
import base.Carrier;
import base.Destination;
import base.TicketClass;

public class TestBoardingPass extends BoardingPass {
    public TestBoardingPass(String id, TicketClass ticketClass) {

        super(id, Carrier.Emirates, "Testflight", null,ticketClass, base.Source.MUC,
                Destination.CPT, "", "", "", "");
    }
}
