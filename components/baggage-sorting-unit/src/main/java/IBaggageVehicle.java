import base.Container;

public interface IBaggageVehicle {
    int store(Container container);
    void connect(Object containerlifterPort);
    void move(String position);
}
