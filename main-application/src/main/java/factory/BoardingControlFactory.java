package factory;

import configuration.Configuration;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class BoardingControlFactory {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object build() {
        Object componentPort = null;

        try {
            // Convert the jar path to a URL
            String jarPath = Configuration.instance.commonPathToJavaArchive + "/boarding-control.jar";
            URL[] urls = { new File(jarPath).toURI().toURL() };

            // Load boarding control class with the designated URLClassLoader
            URLClassLoader urlClassLoader = new URLClassLoader(urls, BoardingControlFactory.class.getClassLoader());
            Class boardingControlClass = Class.forName("BoardingControl", true, urlClassLoader);

            // Return the port instance of BoardingControl
            Object boardingControlInstance = boardingControlClass.getMethod("getInstance").invoke(null);
            componentPort = boardingControlClass.getDeclaredField("port").get(boardingControlInstance);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException |
                NoSuchMethodException | MalformedURLException | InvocationTargetException exc) {
            exc.printStackTrace();
        }

        return componentPort;
    }
}
