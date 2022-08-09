package sky.demo2;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mystudent")
public class Student {
    /*
        @Value：简单类型的属性赋值
            属性：value是string类型的，表示简单类型的属性值
            位置：1.在属性定义的上面，无需set方法，推荐使用
                 2.在set方法上面
    */
    @Value(value = "王悦")
    private String name;
    @Value(value = "29")
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        System.out.println("你好");
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
