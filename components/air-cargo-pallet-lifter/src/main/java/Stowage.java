import java.util.ArrayList;

public class Stowage {

    private ArrayList<Container> containerList;
    private ArrayList<AirCargoPallet> airCargoPalletList;

    public ArrayList<AirCargoPallet> getAirCargoPalletList() {
        return airCargoPalletList;
    }

    public void setAirCargoPalletList(ArrayList<AirCargoPallet> airCargoPalletList) {
        this.airCargoPalletList = airCargoPalletList;
    }

    public ArrayList<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(ArrayList<Container> containerList) {
        this.containerList = containerList;
    }

    public Stowage(ArrayList<Container> containerList) {
        this.containerList = containerList;
    }

    @Override
    public String toString() {
        return "Stowage{" +
                "containerList=" + containerList +
                "airCargoPalletList=" + airCargoPalletList +
                '}';
    }
}
