package edu.cqnu.myproject3.service;

import java.util.ArrayList;
import java.util.List;
import edu.cqnu.myproject3.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentsService {
    private List<Student> students = new ArrayList<>();

    public StudentsService() {
        students.add(new Student(1001, "张三", 30));
        students.add(new Student(1002, "李四", 20));
        students.add(new Student(1003, "王五", 25));
        students.add(new Student(1004, "赵丽", 30));
        students.add(new Student(1005, "底纹", 20));
        students.add(new Student(1006, "张德伟", 25));
        students.add(new Student(1007, "吴丰", 30));
        students.add(new Student(1008, "李都", 20));
        students.add(new Student(1009, "王底", 25));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
