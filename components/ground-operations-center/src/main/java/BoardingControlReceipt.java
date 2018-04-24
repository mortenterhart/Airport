import java.util.ArrayList;

public class BoardingControlReceipt {
    private CheckInDesk.Port checkInDeskPort;
    private PassengerList boardedPassengerList;

    public BoardingControlReceipt() {
        checkInDeskPort = CheckInDesk.getInstance().port;
        boardedPassengerList = new PassengerList(new ArrayList<Passenger>());
    }

    public BoardingControlReceipt(PassengerList list) {
        this();
        boardedPassengerList = list;
    }

    public PassengerList getBoardedPassengerList() {
        return boardedPassengerList;
    }

    public void setBoardedPassengerList(PassengerList boardedPassengerList) {
        this.boardedPassengerList = boardedPassengerList;
    }

    public CheckInDesk.Port getCheckInDeskPort() {
        return checkInDeskPort;
    }

    public void setCheckInDesk(CheckInDesk.Port checkInDeskPort) {
        this.checkInDeskPort = checkInDeskPort;
    }
}
