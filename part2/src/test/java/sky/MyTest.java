package sky;

import Spring_learning.day02.demo2.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void test03(){
        String config = "memo2/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
        Student student = (Student) ac.getBean("mystudent");
//        student.setAge(20);
//        student.setName("王祖贤");
        System.out.println(student);
        Date mydate = (Date) ac.getBean("mydate");
        System.out.println(mydate);
    }

}
