import base.Baggage;
import base.Container;

import java.util.ArrayList;

public class Roboter {

    public Roboter(){}

    public void load(ArrayList<Baggage> baggages, Container container){
        container.store(baggages);
    }

    public void load(Container container, Object baggageVehicle) {
        try {
            IBaggageVehicle vehicle = (IBaggageVehicle) baggageVehicle;
            if(vehicle == null) {
                throw new RuntimeException("BaggageVehicle couldn´t be casted.");
            }
            vehicle.store(container);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void orderBaggageVehicleMove( Object baggageVehicle, String position) {
        try {
            IBaggageVehicle vehicle = (IBaggageVehicle) baggageVehicle;
            if(vehicle == null) {
                throw new RuntimeException("BaggageVehicle couldn´t be casted.");
            }
            vehicle.move(position);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
