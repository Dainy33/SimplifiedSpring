package listener;

import IOC.BeanFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    private BeanFactory factory = new BeanFactory();


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //init IOC container
        //BeanFactory.init();
        factory.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //destroy IOC container
        //BeanFactory.destroy();
        factory.destroy();
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 16:48
 **/
