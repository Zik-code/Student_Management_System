package edu.cqnu.myproject3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.cqnu.myproject3.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}