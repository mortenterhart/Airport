package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class AirCargoPalletLifterFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/airCargoPalletLifter.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, AirCargoPalletLifterFactory.class.getClassLoader());
            Class airCargoPalletLifterClass = Class.forName("AirCargoPalletLifter",true,urlClassLoader);
            Object airCargoPalletLifterInstance = airCargoPalletLifterClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = airCargoPalletLifterClass.getDeclaredField("port").get(airCargoPalletLifterInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}