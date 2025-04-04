package edu.cqnu.myproject3.mapper;

import edu.cqnu.myproject3.model.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;

// 使用 @Mapper 注解将该接口标记为 MyBatis 的数据访问接口，
// MyBatis 会自动为这个接口生成实现类，以便在应用中进行数据库操作
@Mapper
public interface StudentMapper {

    // @Select 注解用于标识一个查询操作
    // 查询结果可能有多条记录,方法的返回值类型应该为 List<Student>，表示查询结果会以 Student 对象的列表形式返回
    @Select("select * from student")
    List<Student> getAll();
    @Select("select * from student where name=#{name}")
    List<Student> getAllByName(String name);
    @Select("select * from student where id=#{id}")
    Student getById(Integer id);
    // SQL 语句 "insert into student values (#{id},#{name},#{age})" 表示向 student 表中插入一条记录，
    // 其中 #{id}、#{name}、#{age} 是占位符，会被传入的 Student 对象的对应属性值所替换
    // 该方法的返回值类型为 int，表 示插入操作影响的行数，通常成功插入一行会返回 1
    @Insert("insert into student values (#{id},#{name},#{age})")
    int insert(Student stu);

    @Update("update student set name=#{name},age=#{age} where id=#{id}")
    int update(Student stu);

    @Delete("delete from student where id=#{id}")
    int deleteById(Integer id);

    @Delete("delete from student where name=#{name}")
    int deleteByName(String name);
}