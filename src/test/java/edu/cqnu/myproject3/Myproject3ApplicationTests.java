package edu.cqnu.myproject3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import edu.cqnu.myproject3.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import edu.cqnu.myproject3.model.Student;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Myproject3ApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    // 1. 新增学生：学号1006，姓名王五，年龄22
    @Test
    void testAddStudent() {
        // 准备数据
        Student wangWu = new Student(1006, "王五", 22);

        // 执行插入
        int insertCount = studentMapper.insert(wangWu);
        System.out.println("【新增学生】插入结果：" + insertCount + "行受影响");

        // 验证
        Student dbStudent = studentMapper.selectById(1006);
        assertNotNull(dbStudent, "新增学生失败：1006号学生不存在");
        System.out.println("新增后查询：" + dbStudent);
        assertEquals("王五", dbStudent.getName(), "姓名错误");
    }

    // 2. 修改学号1002的学生
    @Test
    void testUpdateStudent() {
        // 先插入测试数据（若不存在）
        if (studentMapper.selectById(1002) == null) {
            studentMapper.insert(new Student(1002, "旧姓名", 25));
        }

        // 执行修改：姓名改为"张三"，年龄改为20
        Student updateStu = new Student(1002, "张三", 20);
        int updateCount = studentMapper.updateById(updateStu);

        System.out.println("【修改学生】更新结果：" + updateCount + "行受影响");
        Student dbStu = studentMapper.selectById(1002);
        System.out.println("修改后查询：" + dbStu);
        assertEquals(20, dbStu.getAge(), "年龄修改失败");
        assertEquals("张三", dbStu.getName(), "姓名修改失败");
    }

    // 4. 删除年龄>20岁的学生
    @Test
    void testDeleteOver20() {
        // 准备测试数据（包含超龄数据）
        studentMapper.insert(new Student(1007, "超龄1", 23));
        studentMapper.insert(new Student(1008, "超龄2", 24));

        // 执行删除
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20);  // 年龄>20
        int deleteCount = studentMapper.delete(wrapper);

        System.out.println("\n【删除>20岁学生】删除结果：" + deleteCount + "行受影响");

        // 验证剩余数据
        List<Student> remaining = studentMapper.selectList(null);
        System.out.println("删除后剩余学生（共" + remaining.size() + "人）：");
        remaining.forEach(System.out::println);

        assertTrue(remaining.stream()
                        .noneMatch(s -> s.getAge() > 20),
                "存在超龄学生未删除");
    }

    // 测试数据准备（私有方法）
    private void prepareTestData() {
        // 确保基础数据存在
        studentMapper.insert(new Student(1001, "测试1", 18));
        studentMapper.insert(new Student(1002, "测试2", 20)); // 后续会被修改
        studentMapper.insert(new Student(1003, "测试3", 22));
        studentMapper.insert(new Student(1004, "测试4", 25)); // 用于删除测试
    }
}