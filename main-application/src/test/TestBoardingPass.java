import base.BoardingPass;
import base.Carrier;
import base.TicketClass;
import base.Source;
import base.Destination;

public class TestBoardingPass extends BoardingPass {
    public TestBoardingPass(String id, TicketClass ticketClass) {

        super(id, Carrier.Emirates, "Testflight", null,ticketClass, Source.MUC,
                Destination.CPT, "", "", "", "");
    }
}
