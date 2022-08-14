package sky;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sky.demo6.SomeServiceImp;


/**
 * @author yqb
 * @Date 2022/8/12 17:14
 */
public class Mytest6 {
    @Test
    public void test1(){
        String config = "demo6/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        //目标类没有接口，使用cglib动态代理，spring框架会自动应用cglib
        //sky.demo6.SomeServiceImp$$EnhancerBySpringCGLIB$$8cb2c19d
        SomeServiceImp ss = (SomeServiceImp) ac.getBean("someservice");
        //通过代理的对象执行方法实现目标方法是增强了功能
//        ss.dosome("1");
        ss.dosome("huangyao");
        System.out.println(ss.getClass().getName());

        /**
         * @author yqb
         * 有接口也可以使用cglib动态代理
         *加入<aop:aspectj-autoproxy proxy-target-class="true"/>
         *         表示使用cglib动态代理，有接口也可以使用cglib
         */

    }
}
