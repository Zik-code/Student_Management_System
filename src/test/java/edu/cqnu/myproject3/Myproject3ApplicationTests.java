package edu.cqnu.myproject3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import edu.cqnu.myproject3.mapper.StudentMapper;

@SpringBootTest
class Myproject3ApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    void contextLoads() {
        List<Student> students =studentMapper.getAll();
        for(Student student : students){
            System.out.println("student = " + student);
        }
    }

}
