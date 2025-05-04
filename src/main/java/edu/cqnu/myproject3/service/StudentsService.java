package edu.cqnu.myproject3.service;

import edu.cqnu.myproject3.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {
    private List<Student> students = new ArrayList<>();

    public StudentsService() {
        // 初始化一些学生数据示例
        students.add(new Student(1001, "学生1", 18));
        students.add(new Student(1002, "学生2", 20));
        students.add(new Student(1003, "学生3", 22));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}