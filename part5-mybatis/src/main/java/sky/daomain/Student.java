package sky.daomain;

/**
 * @author yqb
 * @Date 2022/8/14 19:54
 */
public class Student {
    public String name;
    public int age;
    public int score;
    public String address;

    public Student() {
    }

    public Student(String name, int age, int score, String address) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public String getAddress() {
        return address;
    }
}
