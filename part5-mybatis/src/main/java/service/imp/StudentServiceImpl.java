package service.imp;

import dao.StudentDao;
import service.StudentService;
import sky.daomain.Student;

import java.util.List;

/**
 * @author yqb
 * @Date 2022/8/15 11:16
 */
public class StudentServiceImpl implements StudentService {
    //引用类型
    private StudentDao studentDao;
    //set注入，赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int num = studentDao.add(student);
        return num;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
