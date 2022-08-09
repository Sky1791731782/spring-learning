package sky.demo3;

public class Student {
    private String name;
    private int age;
    private School school;
    public Student(){
        System.out.println("无参构造器");
    }
    public Student(String name, int age, School school) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
        this.school = school;
    }

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
