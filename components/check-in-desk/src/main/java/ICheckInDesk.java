import java.util.ArrayList;

public interface ICheckInDesk {
    BoardingPass checkIn(Passenger passenger, ArrayList<Baggage> baggage);
    boolean scan(Passport passport);
    void print(BoardingPass boardingPass);
    BaggageIdentificationTag checkIn(Baggage baggage);
    void notifyGroundOperations(CheckInDeskReceipt checkInDeskReceipt);
}
