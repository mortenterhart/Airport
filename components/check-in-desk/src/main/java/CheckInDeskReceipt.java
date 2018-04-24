public class CheckInDeskReceipt {
    public CheckInDeskReceipt(String flight, Source source, Destination destination, String date, String boardingTime, String gate, int numberOfPassengersFirstClass, int numberOfPassengersBusinessClass, int numberOfPassengersEconomyClass, int numberOfBaggage) {
        this.flight = flight;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.boardingTime = boardingTime;
        this.gate = gate;
        this.numberOfPassengersFirstClass = numberOfPassengersFirstClass;
        this.numberOfPassengersBusinessClass = numberOfPassengersBusinessClass;
        this.numberOfPassengersEconomyClass = numberOfPassengersEconomyClass;
        this.numberOfBaggage = numberOfBaggage;
    }

    private String flight;
    private Source source;
    private Destination destination;
    private String date;
    private String boardingTime;
    private String gate;
    private int numberOfPassengersFirstClass;
    private int numberOfPassengersBusinessClass;
    private int numberOfPassengersEconomyClass;
    private int numberOfBaggage;

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public int getNumberOfPassengersFirstClass() {
        return numberOfPassengersFirstClass;
    }

    public void setNumberOfPassengersFirstClass(int numberOfPassengersFirstClass) {
        this.numberOfPassengersFirstClass = numberOfPassengersFirstClass;
    }

    public int getNumberOfPassengersBusinessClass() {
        return numberOfPassengersBusinessClass;
    }

    public void setNumberOfPassengersBusinessClass(int numberOfPassengersBusinessClass) {
        this.numberOfPassengersBusinessClass = numberOfPassengersBusinessClass;
    }

    public int getNumberOfPassengersEconomyClass() {
        return numberOfPassengersEconomyClass;
    }

    public void setNumberOfPassengersEconomyClass(int numberOfPassengersEconomyClass) {
        this.numberOfPassengersEconomyClass = numberOfPassengersEconomyClass;
    }

    public int getNumberOfBaggage() {
        return numberOfBaggage;
    }

    public void setNumberOfBaggage(int numberOfBaggage) {
        this.numberOfBaggage = numberOfBaggage;
    }
}
