package bean;

import IOC.BeanContainer;
import annotation.Bean;
import utils.ClazzUtils;

import java.util.List;
import java.util.Map;

public class BeansInit {

    Map<String, Object> container = BeanContainer.getContainer();

    //Init based on type's annotation
    public boolean initBeansBasedOnPackage(String packageName) {
        try {
            List<String> names = ClazzUtils.getClazzName(packageName, false);
            for (String name : names) {
                Class<?> clazz = Class.forName(name);
                Bean bean = clazz.getAnnotation(Bean.class);
                if (bean == null) {
                    continue;
                }
                Object o = clazz.newInstance();
                container.put(name,o);
            }
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return false;
    }
}
