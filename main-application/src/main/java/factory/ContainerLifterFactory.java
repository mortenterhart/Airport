package factory;

import configuration.Configuration;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ContainerLifterFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/containerLifter.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ContainerLifterFactory.class.getClassLoader());
            Class containerLifterClass = Class.forName("ContainerLifter",true,urlClassLoader);
            Object containerLifterInstance = containerLifterClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = containerLifterClass.getDeclaredField("port").get(containerLifterInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
