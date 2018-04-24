import java.util.ArrayList;

public interface IContainerLifter {
    boolean up();
    boolean down();
    int lift(ArrayList<Container> containerList, Stowage stowage);
    void notifyGroundOperations(ContainerLifterReceipt containerLifterReceipt);
}
