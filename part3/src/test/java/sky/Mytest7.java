package sky;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sky.demo7.Student;

public class Mytest7 {
    @Test
    public void test01(){
        String config = "memo4/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("mystudent");
        System.out.println(student);
    }
}
