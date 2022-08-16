package dao;

import sky.daomain.Student;

import java.util.List;

public interface StudentDao {
    int add(Student student);
    List<Student> selectStudents();

}
