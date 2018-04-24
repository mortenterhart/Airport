import base.Baggage;
import base.Passenger;

public class MockScanner {

    public boolean scan(Baggage baggage, String pattern) {
        return baggage.getId().toLowerCase().contains(pattern.toLowerCase());
    }

    public boolean scan(Passenger passenger, String pattern) {
        if(passenger.getContent().toLowerCase().contains(pattern.toLowerCase())) {
            return true;
        }
        if(passenger.getBaggageList() != null) {
            for(Baggage baggage : passenger.getBaggageList()) {
                if(scan(baggage, pattern)) {
                    return true;
                }
            }
        }
        return false;
    }
}