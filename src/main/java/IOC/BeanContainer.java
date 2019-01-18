package IOC;

import java.util.HashMap;
import java.util.Map;

public class BeanContainer {

    private static Map<String,Object> container = new HashMap<>();

    private BeanContainer() {
    }

    public static Map<String,Object> getContainer(){
        return container;
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 18:10
 **/
