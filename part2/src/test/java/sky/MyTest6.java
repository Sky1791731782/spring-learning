package sky;

import Spring_learning.day02.demo6.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest6 {

    @Test
    public void test01(){
        String config = "memo06/spring_total.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
        Student student = (Student) ac.getBean("mystudent");

        System.out.println(student);
    }

}
