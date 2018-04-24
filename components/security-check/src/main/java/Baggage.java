package base;

public class Baggage {

    private String id;
    private double weight;
    private base.BaggageType baggageType;

    public Baggage(String id, double weight, base.BaggageType baggageType) {
        this.id = id;
        this.weight = weight;
        this.baggageType = baggageType;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public base.BaggageType getBaggageType() {
        return baggageType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBaggageType(base.BaggageType baggageType) {
        this.baggageType = baggageType;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                ", baggageType=" + baggageType +
                '}';
    }
}
