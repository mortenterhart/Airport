package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class SpecialGoodRoboterFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/specialGoodRoboter.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SpecialGoodRoboterFactory.class.getClassLoader());
            Class specialGoodRoboterClass = Class.forName("SpecialGoodRoboter",true,urlClassLoader);
            Object specialGoodRoboterInstance = specialGoodRoboterClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = specialGoodRoboterClass.getDeclaredField("port").get(specialGoodRoboterInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}