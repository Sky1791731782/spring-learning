package sky.demo6;

public class Student {
    private String name;
    private int age;
    private School school;
    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{ " +
                "name= '" + name + '\'' +
                ", age= " + age +
                ", " + school +
                '}';
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
