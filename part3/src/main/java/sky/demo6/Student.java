package sky.demo6;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*
    引用类型:
    @Resource:来自jdk中的注解，spring框架提供了对这个注解的功能支持，可以用来给引用类型赋值
    使用的也是自动注入的方式，支持byName，byType默认是byName
    位置:
            1.属性定义的上面无需set方法，推荐使用
            2.在set方法上面
     先使用byName，如果不行则使用byType
     只使用byName需要增加属性name
     name的值是bean的id
*/

@Component(value = "mystudent")
public class Student {
    @Value("鞠婧祎")
    private String name;
    @Value("20")
    private int age;
    @Resource(name = "school")
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
