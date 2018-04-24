package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class ServiceVehicleWasteWaterTankFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/serviceVehicleWasteWaterTank.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ServiceVehicleWasteWaterTankFactory.class.getClassLoader());
            Class serviceVehicleWasteWaterTank = Class.forName("ServiceVehicleWasteWaterTank",true,urlClassLoader);
            Object serviceVehicleWasteWaterTankInstance = serviceVehicleWasteWaterTank.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = serviceVehicleWasteWaterTank.getDeclaredField("port").get(serviceVehicleWasteWaterTankInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }




}
