import java.util.ArrayList;

public class ContainerLifterReceipt {
    Stowage stowage;
    ArrayList<Container> containerList;

    public ContainerLifterReceipt(Stowage stowage, ArrayList<Container> containerList) {
        this.stowage = stowage;
        this.containerList = containerList;
    }

    public Stowage getStowage() {
        return stowage;
    }

    public void setStowage(Stowage stowage) {
        this.stowage = stowage;
    }

    public ArrayList<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(ArrayList<Container> containerList) {
        this.containerList = containerList;
    }
}