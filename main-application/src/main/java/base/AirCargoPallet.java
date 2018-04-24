package base;

public class AirCargoPallet {
    private String id;
    private String weight;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public AirCargoPallet(String id, String weight) {
        this.id = id;
        this.weight = weight;
    }
}
