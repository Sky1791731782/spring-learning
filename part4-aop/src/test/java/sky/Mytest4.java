package sky;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sky.demo4.SomeService;


/**
 * @author yqb
 * @Date 2022/8/12 17:14
 */
public class Mytest4 {
    @Test
    public void test1(){
        String config = "demo4/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService ss = (SomeService) ac.getBean("someservice");
        //通过代理的对象执行方法实现目标方法是增强了功能
//        ss.dosome("1");
        ss.dosome("huangyao");
        System.out.println();
    }
}
