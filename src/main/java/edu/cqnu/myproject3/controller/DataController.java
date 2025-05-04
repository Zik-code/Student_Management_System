package edu.cqnu.myproject3.controller;

import edu.cqnu.myproject3.mapper.StudentMapper;
import edu.cqnu.myproject3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {
    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/addstu")
    public String add(Student student) {
        try {
            int res = studentMapper.insert(student);
            if (res == 1) {
                return "success";
            } else {
                return "failure";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "failure";
        }
    }
}