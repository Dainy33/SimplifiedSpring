package listener;

import IOC.IOCContainer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //init IOC container
        IOCContainer.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //destroy IOC container
        IOCContainer.destroy();
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 16:48
 **/
