package sky.demo3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
    引用类型赋值:
       @Autowired: 自动注入原理支持byName,byType 默认使用的是byType
            位置：1.属性定义的上面无需set方法，推荐使用
                 2.在set方法上面
*/

@Component(value = "mystudent")
public class Student {
    @Value("鞠婧祎")
    private String name;
    @Value("20")
    private int age;
    @Autowired
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
