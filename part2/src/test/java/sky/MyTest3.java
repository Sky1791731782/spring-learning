package sky;

import Spring_learning.day02.demo3.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest3 {

    @Test
    public void test03(){
        String config = "memo03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
        Student student = (Student) ac.getBean("mystudent");
        Student student1 = (Student) ac.getBean("mystudent1");
        Student student2= (Student) ac.getBean("mystudent2");
        File file = (File) ac.getBean("myfile");
        System.out.println(file.getName());
    }

}
