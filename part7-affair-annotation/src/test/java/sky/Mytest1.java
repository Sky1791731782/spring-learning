package sky;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import service.BuyGoodService;

/**
 * @author yqb
 * @Date 2022/8/17 19:55
 */
public class Mytest1 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        BuyGoodService service = (BuyGoodService) ac.getBean("buyService");
        service.buy(1002,20);
    }
}
