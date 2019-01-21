import IOC.BeanFactory;
import model.Card;
import org.junit.Test;

public class BeanTest {
    @Test
    public void getTest() {
        BeanFactory factory = new BeanFactory();
        factory.init();
        Object bean = factory.getBean(Card.class);
        factory.destroy();
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 17:46
 **/
