package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ServiceVehicleOilFactory {

    public static Object build() {
        Object componentPort = null;
        String fileSeparator = System.getProperty("file.separator");

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + fileSeparator + "serviceVehicleOil.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ServiceVehicleOilFactory.class.getClassLoader());
            Class serviceVehicleOilClass = Class.forName("ServiceVehicleOil",true,urlClassLoader);
            Object serviceVehicleOilInstance = serviceVehicleOilClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = serviceVehicleOilClass.getDeclaredField("port").get(serviceVehicleOilInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
