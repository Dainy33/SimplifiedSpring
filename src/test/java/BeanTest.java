import bean.BeansLoader;
import org.junit.Test;

public class BeanTest {
    @Test
    public void getTest(){
        BeansLoader loader = new BeansLoader();
        String packageName = "model";
        loader.loadBeansBasedOnPackage(packageName);
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-18 17:46
 **/
