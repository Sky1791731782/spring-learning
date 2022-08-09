package sky.demo1;


import org.springframework.stereotype.Component;

/**
 * @Componet: 创建对象的等同于bean
 *      属性value: 是对象的名称对应bean中ID值
 *          value值是唯一的，创建的对象在整个spring容器中就一个
 * 位置：在类上面
 * @Component(value = "mystudent")等同于
 * <bean id ="mystudent" class="org.annotationUse.ComponentdDemo.Student"/>
 *创建对象的注解还有
 *  1.@Repository
 *  2.@Service
 *  3.@Controller
 * /
/**
 *@Component("mystudent") 最常用
 * @Component 默认名是类名首字母小写
 *
 * 指定多种包的方式:
 * 1.多条@Component注解
 * 2.使用分隔符(, ;)
 * 3.指定父包
 */

@Component(value = "mystudent")
public class Student {
    private String name;
    private int age;
    private School school;
    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
