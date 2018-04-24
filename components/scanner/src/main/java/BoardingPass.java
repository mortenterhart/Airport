package base;

public class BoardingPass {

    private String id;
    private base.Carrier carrier;
    private String flight;
    private base.Passenger passenger;
    private base.TicketClass ticketClass;
    private base.Source source;
    private base.Destination destination;
    private String date;
    private String gate;
    private String boardingTime;
    private String seat;

    public BoardingPass(String id, base.Carrier carrier, String flight, base.Passenger passenger,
                        base.TicketClass ticketClass, base.Source source, base.Destination destination,
                        String date, String gate, String boardingTime, String seat) {
        this.id = id;
        this.carrier = carrier;
        this.flight = flight;
        this.passenger = passenger;
        this.ticketClass = ticketClass;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.gate = gate;
        this.boardingTime = boardingTime;
        this.seat = seat;
    }

    public String getId() {
        return id;
    }

    public base.Carrier getCarrier() {
        return carrier;
    }

    public String getFlight() {
        return flight;
    }

    public base.Passenger getPassenger() {
        return passenger;
    }

    public base.TicketClass getTicketClass() {
        return ticketClass;
    }

    public base.Source getSource() {
        return source;
    }

    public base.Destination getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getGate() {
        return gate;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCarrier(base.Carrier carrier) {
        this.carrier = carrier;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public void setPassenger(base.Passenger passenger) {
        this.passenger = passenger;
    }

    public void setTicketClass(base.TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public void setSource(base.Source source) {
        this.source = source;
    }

    public void setDestination(base.Destination destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
                "id='" + id + '\'' +
                ", carrier=" + carrier +
                ", flight='" + flight + '\'' +
                ", passenger=" + passenger +
                ", ticketClass=" + ticketClass +
                ", source=" + source +
                ", destination=" + destination +
                ", date='" + date + '\'' +
                ", gate='" + gate + '\'' +
                ", boardingTime='" + boardingTime + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
