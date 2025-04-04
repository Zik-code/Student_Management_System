package edu.cqnu.myproject3.controller;
import edu.cqnu.myproject3.service.StudentsService;
import edu.cqnu.myproject3.model.Student;
import edu.cqnu.myproject3.service.LessonsService;
import edu.cqnu.myproject3.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.cqnu.myproject3.mapper.StudentMapper;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private LessonsService lessonsService;

    @GetMapping("/")
    public String home(Model model) {
        List<Student> students= studentMapper.getAll();
        model.addAttribute("students", students);
        return "main/home";
    }

    @GetMapping("main/lesson")
    public String lesson(Model model) {
        model.addAttribute("lessons", lessonsService.getLessons());
        return "main/lesson";
    }

    @GetMapping("/addLes")
    public String addLes() {
        return "main/addLes";
    }

    @PostMapping("/addLes")
    public String add(Lesson lesson, RedirectAttributes redirectAttributes) {
        // 检查学生是否已存在
        for (Lesson les : lessonsService.getLessons()) {
            if (les.getId().equals(lesson.getId())) {
                return "redirect:/main/lesson";
            }
        }
        // 学生不存在，添加到列表并添加提示信息
        lessonsService.getLessons().add(lesson);
        return "redirect:/main/lesson";
    }

    @GetMapping("/editLes")
    public String editLes(Integer id, Model model) {
        for (Lesson les1 : lessonsService.getLessons()) {
            if (les1.getId().equals(id)) {
                model.addAttribute("les", les1);
                return "main/editLes";
            }
        }
        return "redirect:/main/lesson";
    }

    @PostMapping("/editLes")
    public String edit(Lesson lesson) {
        for (Lesson les : lessonsService.getLessons()) {
            if (les.getId().equals(lesson.getId())) {
                les.setId(lesson.getId());
                les.setName(lesson.getName());
                les.setTeacher(lesson.getTeacher());
                return "redirect:/main/lesson";
            }
        }
        return "redirect:/main/lesson";
    }

    @GetMapping("/delLes")
    public String del1(Integer id) {
        Lesson a = null;
        for (Lesson lesson : lessonsService.getLessons()) {
            if (lesson.getId().equals(id)) {
                a = lesson;
                break;
            }
        }
        if (a != null) {
            lessonsService.getLessons().remove(a);
        }
        return "redirect:/main/lesson";
    }


    @GetMapping("/addStu")
    public String addStu() {

        return "main/addStu";
    }

    @PostMapping("/addStu")
    public String add(Student student, RedirectAttributes redirectAttributes, Model model) {
        try {
            int res = studentMapper.insert(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }



    @GetMapping("/editStu")
    public String editStu(Integer id, Model model) {
        Student stu=studentMapper.getById(id);
        model.addAttribute("stu", stu);

        return "main/editStu";
    }

    @PostMapping("/editStu")
    public String edit(Student student) {

        try {
            studentMapper.update(student);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/delStu")
    public String del(Integer id) {

        try {
            studentMapper.deleteById(id);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return "redirect:/";
    }


}