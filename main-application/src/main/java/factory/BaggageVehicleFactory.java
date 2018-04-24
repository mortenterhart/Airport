package factory;

import configuration.Configuration;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class BaggageVehicleFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/baggageVehicle.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, BaggageVehicleFactory.class.getClassLoader());
            Class baggageVehicleClass = Class.forName("BaggageVehicle",true,urlClassLoader);
            Object baggageVehicleInstance = baggageVehicleClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = baggageVehicleClass.getDeclaredField("port").get(baggageVehicleInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}

