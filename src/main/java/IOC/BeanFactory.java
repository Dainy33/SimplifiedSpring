package IOC;

import bean.BeansBind;
import bean.BeansInit;
import bean.BeansLoader;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    private Map<String,Object> container = BeanContainer.getContainer();

    private BeansLoader loader = new BeansLoader();

    private BeansInit beansInit = new BeansInit();

    private BeansBind beansBind = new BeansBind();

    public BeanFactory() {
        init();
    }

    //based on annotation
    public void init() {

        //create Beans
        //scan path to get Class's name
        //annotation and reflection

        //TODO get package name list from config
        List<String> packageNames = new ArrayList<>();
        String packageName = "model";
        packageNames.add(packageName);

        for (String name : packageNames) {
            beansInit.initBeansBasedOnPackage(name);
            beansBind.bindedBeansBasedOnPackage(name);
            //loader.loadBeansBasedOnPackage(name);
        }

    }

    public void destroy() {
        //destroy Beans
    }

    public Object getBean(Class clazz){
        String name = clazz.getName();
        Object o = container.get(name);
        return o;
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 16:49
 **/
