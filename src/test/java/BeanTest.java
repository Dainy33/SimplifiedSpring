import IOC.BeanFactory;
import bean.BeansLoader;
import model.Card;
import org.junit.Test;

public class BeanTest {
    @Test
    public void getTest(){
        BeanFactory factory = new BeanFactory();
        Object bean = factory.getBean(Card.class);
        System.out.println();
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 17:46
 **/
