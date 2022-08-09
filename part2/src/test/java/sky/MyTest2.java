package sky;

import Spring_learning.day02.demo2.Student;
import Spring_learning.day02.demo2.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest2 {
    @Test
    public void test02(){
        Spring_learning.day02.demo2.Student student = new Spring_learning.day02.demo2.Student();
        student.setAge(10);
        student.setName("xiaoming");
        School school = new School();
        school.setName("xiaoxue");
        school.setAddress("beijing");
        student.setSchool(school);
        System.out.println(student);
    }

    @Test
    public void test03(){
        String config = "memo2/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
        Student student = (Student) ac.getBean("mystudent");
        System.out.println(student);
    }

}
