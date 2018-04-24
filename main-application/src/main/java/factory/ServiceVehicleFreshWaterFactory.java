package factory;

import configuration.Configuration;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ServiceVehicleFreshWaterFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/serviceVehicleFreshWater.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ServiceVehicleFreshWaterFactory.class.getClassLoader());
            Class serviceVehicleFreshWaterClass = Class.forName("ServiceVehicleFreshWater",true,urlClassLoader);
            Object serviceVehicleFreshWaterInstance = serviceVehicleFreshWaterClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = serviceVehicleFreshWaterClass.getDeclaredField("port").get(serviceVehicleFreshWaterInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
