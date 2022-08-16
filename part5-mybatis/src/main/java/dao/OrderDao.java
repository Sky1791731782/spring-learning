package dao;

import sky.daomain.Student;

import java.util.List;

public interface OrderDao {
    int add(Student student);
    List<Student> selectStudents();

}
