package sky.demo4.demo3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
    引用类型赋值:
       @Autowired: 自动注入原理支持byName,byType 默认使用的是byType
            位置：1.属性定义的上面无需set方法，推荐使用
                 2.在set方法上面
           如果使用的是byName 方式：
                 1.在属性上面加入@Autowired注解
                 2.在属性上面加入@Qualifier(value = "bean的id"):表示使用指定名称完成赋值
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
