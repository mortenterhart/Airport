package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class GroundOperationsCenterFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive+Configuration.instance.fileSeparator+"ground-operations-center.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, GroundOperationsCenterFactory.class.getClassLoader());
            Class GroundOperationsCenterClass = Class.forName("GroundOperationsCenter", true, urlClassLoader);
            Object GroundOperationsCenterInstance = GroundOperationsCenterClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = GroundOperationsCenterClass.getDeclaredField("port").get(GroundOperationsCenterInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}
