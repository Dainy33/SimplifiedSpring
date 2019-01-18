package bean;

import annotation.Bean;
import annotation.Value;
import utils.ClazzUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeansLoader {

    private List<Object> container = new ArrayList<>();

    //scan based on package
    public boolean loadBeansBasedOnPackage(String packageName) {

        List<String> clazzName = ClazzUtils.getClazzName(packageName, false);

        for (String name : clazzName) {

            getObjectByClazzName(name);
        }

        return true;
    }

    private Object getObjectByClazzName(String name) {

        try {

            Class<?> clazz = Class.forName(name);
            Bean annotation = clazz.getAnnotation(Bean.class);
            if(annotation==null){
                return null;
            }
            Object o = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Value value = field.getAnnotation(Value.class);
                if (value == null) {
                    continue;
                }
                field.setAccessible(true);
                field.set(o, value.value());
            }

            container.add(o);

            return o;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 17:12
 **/
