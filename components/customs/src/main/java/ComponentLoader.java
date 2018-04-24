import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ComponentLoader {
    public static Object loadComponent(String componentName, String className, String callingComponent) {
        try {
            String url = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").lastIndexOf(System.getProperty("file.separator")+callingComponent+System.getProperty("file.separator")+"src"))+ System.getProperty("file.separator") + componentName + System.getProperty("file.separator") +"target"+ System.getProperty("file.separator") + componentName + "-1.0.0.jar";
            URL[] urls = {new File(url).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ComponentLoader.class.getClassLoader());
            Class clazz = Class.forName(className, true, urlClassLoader);
            Object instance = clazz.getMethod("getInstance").invoke(null);
            return clazz.getDeclaredField("port").get(instance);
        } catch (Exception e) {
            throw new RuntimeException("Could not load component", e);
        }
    }
}