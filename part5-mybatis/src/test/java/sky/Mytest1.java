package sky;

import dao.StudentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;
import sky.daomain.Student;

import java.util.List;

/**
 * @author yqb
 * @Date 2022/8/15 21:37
 */
public class Mytest1 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        String[] objects = ac.getBeanDefinitionNames();
        System.out.println();
        System.out.println();
        System.out.println("==================================");
        for(String name : objects){
            System.out.println("容器中的对象: "+name+" "+ac.getBean(name).getClass().getName());
        }
    }
    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");
//        Student student1 = new Student("曾黎",40,50,"湖北省荆州市沙市区");
        Student student1 = new Student();
        student1.setName("曾黎");
        student1.setAge(40);
        student1.setScore(50);
        student1.setAddress("湖北省荆州市沙市区");
        int num = studentDao.add(student1);
//        = studentDao.selectStudents();
        System.out.println(num);

    }
    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService service = (StudentService) ac.getBean("studentService");
//        Student student1 = new Student("曾黎",40,50,"湖北省荆州市沙市区");
        Student student1 = new Student("李灿",25,60,"湖北武汉");
        int num = service.addStudent(student1);

//        spring和mybatis整合时，事务自动提交，无需执行SqlSession.commit()
        System.out.println(num);

    }
    @Test
    public void test04(){//查询
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService service = (StudentService) ac.getBean("studentService");
        List<Student> students = service.queryStudent();
        students.forEach(System.out::println);

    }
}
