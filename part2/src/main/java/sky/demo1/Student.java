package sky.demo1;

public class Student {
    private String name;
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
