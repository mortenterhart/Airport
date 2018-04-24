import java.util.ArrayList;

public class BaggageVehicle {
    public Container container;

    public static BaggageVehicle instance = new BaggageVehicle();

    public static BaggageVehicle getInstance() {
        return instance;
    }

    public Port port;


    public BaggageVehicle() {port =new Port();}


    public class Port implements IBaggageVehicle {

        private Object containerLifterPort;

        public int store(Container container){
            return innerStore(container);
        }

        public void connect(Object containerLifterPort){
            innerConnect(containerLifterPort);
        }

        public void move(String position){innerMove(position);}

    }

    public int innerStore(Container container1){
        container = container1;
        return 1;
    }

    public void innerConnect(Object containerlifter){
        ArrayList<Container> containers=new ArrayList<Container>();
        containers.add(container);
    }

    public void innerMove(String position){

    }
}
