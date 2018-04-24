package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ServiceVehicleNitrogenOxygenFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/serviceVehicleNitrogenOxygen.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ServiceVehicleNitrogenOxygenFactory.class.getClassLoader());
            Class serviceVehicleNitrogenOxygen = Class.forName("ServiceVehicleNitrogenOxygen",true,urlClassLoader);
            Object serviceVehicleNitrogenOxygenInstance = serviceVehicleNitrogenOxygen.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = serviceVehicleNitrogenOxygen.getDeclaredField("port").get(serviceVehicleNitrogenOxygenInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }




}
