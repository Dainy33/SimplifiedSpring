package bean;

import IOC.BeanContainer;
import annotation.Autowired;
import annotation.Value;
import utils.StringUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class BeansBind {

    Map<String,Object> container = BeanContainer.getContainer();

    //bind based on field's annotation
    public boolean bindedBeansBasedOnPackage(String packageName){
        try {
            for(Map.Entry<String,Object> entry:container.entrySet()){
                String name = entry.getKey();
                Object o = entry.getValue();
                Class<?> clazz = Class.forName(name);
                Field[] fields = clazz.getDeclaredFields();
                for(Field field :fields){
                    Value value = field.getAnnotation(Value.class);
                    if(value==null){
                        continue;
                    }
                    String fieldName = field.getName();
                    field.setAccessible(true);
                    field.set(o,value.value());
                }
                for(Field field :fields) {
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    if(autowired==null){
                        continue;
                    }
                    String fieldName = field.getName();
                    String relativeName = packageName + "." + StringUtils.UpperCaseFirstChar(fieldName);
                    Object o1 = container.get(relativeName);
                    field.setAccessible(true);
                    field.set(o,o1);
                }

                }



            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

}
