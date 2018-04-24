package base;

public class LuggageTub {

    private base.Baggage baggage;
    private base.Destination destination;

    public LuggageTub(base.Baggage baggage, base.Destination destination) {
        this.baggage = baggage;
        this.destination = destination;
    }

    public base.Baggage getBaggage() {
        return baggage;
    }

    public void setBaggage(base.Baggage baggage) {
        this.baggage = baggage;
    }

    public base.Destination getDestination() {
        return destination;
    }

    public void setDestination(base.Destination destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "LuggageTub{" +
                "baggage=" + baggage +
                ", destination=" + destination +
                '}';
    }
}
