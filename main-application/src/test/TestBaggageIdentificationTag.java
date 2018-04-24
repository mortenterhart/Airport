import base.BaggageIdentificationTag;
import base.Carrier;

public class TestBaggageIdentificationTag extends BaggageIdentificationTag {
    public TestBaggageIdentificationTag(String id, TestBoardingPass testBoardingPass) {


        super(id, testBoardingPass, Carrier.Emirates, 0,
                "", "", null, null, null, true, true, true
                ,"");
    }
}
