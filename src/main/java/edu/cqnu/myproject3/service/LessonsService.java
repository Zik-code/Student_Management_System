package edu.cqnu.myproject3.service;

import edu.cqnu.myproject3.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonsService {
    private List<Lesson> lessons = new ArrayList<>();

    public LessonsService() {
        lessons.add(new Lesson(1111, "编程语言", "王琦"));
        lessons.add(new Lesson(1112, "思政", "李五"));
        lessons.add(new Lesson(1113, "Code - Making", "何七"));
        lessons.add(new Lesson(1114, "学术报告", "张三"));
        lessons.add(new Lesson(1115, "计算机网络", "刘的"));
        lessons.add(new Lesson(1116, "数据库原理", "陈大"));
        lessons.add(new Lesson(1117, "软件工程", "赵伟"));
        lessons.add(new Lesson(1118, "数字逻辑", "孙成"));
        lessons.add(new Lesson(1119, "操作系统", "周菜"));
        lessons.add(new Lesson(1120, "算法分析与设计", "吴外"));
        lessons.add(new Lesson(1121, "人工智能基础", "郑相"));
        lessons.add(new Lesson(1122, "大数据技术", "王研"));
        lessons.add(new Lesson(1123, "物联网应用", "冯老"));
        lessons.add(new Lesson(1124, "移动开发技术", "褚师"));
        lessons.add(new Lesson(1125, "云计算基础", "卫大"));
        lessons.add(new Lesson(1126, "信息安全概论", "蒋测"));
        lessons.add(new Lesson(1127, "图形图像处理", "沈选"));
        lessons.add(new Lesson(1128, "多媒体技术", "韩存"));
        lessons.add(new Lesson(1129, "网络编程", "杨测"));
        lessons.add(new Lesson(1130, "软件测试", "朱没"));
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}