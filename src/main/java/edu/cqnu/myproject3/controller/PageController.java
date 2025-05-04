package edu.cqnu.myproject3.controller;

import edu.cqnu.myproject3.mapper.StudentMapper;
import edu.cqnu.myproject3.service.LessonsService;
import edu.cqnu.myproject3.service.StudentsService;
import edu.cqnu.myproject3.model.Lesson;
import edu.cqnu.myproject3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private LessonsService lessonsService;
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentsService.getStudents());
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
    public String addLesson(Lesson lesson, RedirectAttributes redirectAttributes) {
        List<Lesson> lessons = lessonsService.getLessons();
        for (Lesson les : lessons) {
            if (les.getId().equals(lesson.getId())) {
                return "redirect:/main/lesson";
            }
        }
        lessons.add(lesson);
        return "redirect:/main/lesson";
    }

    @GetMapping("/editLes")
    public String editLes(Integer id, Model model) {
        List<Lesson> lessons = lessonsService.getLessons();
        for (Lesson les1 : lessons) {
            if (les1.getId().equals(id)) {
                model.addAttribute("les", les1);
                return "main/editLes";
            }
        }
        return "redirect:/main/lesson";
    }

    @PostMapping("/editLes")
    public String editLesson(Lesson lesson) {
        List<Lesson> lessons = lessonsService.getLessons();
        for (Lesson les : lessons) {
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
        List<Lesson> lessons = lessonsService.getLessons();
        Lesson a = null;
        for (Lesson lesson : lessons) {
            if (lesson.getId().equals(id)) {
                a = lesson;
                break;
            }
        }
        if (a != null) {
            lessons.remove(a);
        }
        return "redirect:/main/lesson";
    }

    @GetMapping("/addstu")
    public String addstu() {
        return "main/addStu";
    }

    @GetMapping("/editStu")
    @ResponseBody
    public Student editStu(@RequestParam Integer id) {
        List<Student> students = studentsService.getStudents();
        for (Student stu : students) {
            if (stu.getId().equals(id)) {
                return stu;
            }
        }
        return null;
    }

    @PostMapping("/editStu")
    @ResponseBody
    public String editStudent(@RequestBody Student student) {
        List<Student> students = studentsService.getStudents();
        for (Student stu : students) {
            if (stu.getId().equals(student.getId())) {
                stu.setName(student.getName());
                stu.setAge(student.getAge());
                return "success";
            }
        }
        return "failure";
    }

    @GetMapping("/delStu")
    @ResponseBody
    public String del(@RequestParam Integer id) {
        List<Student> students = studentsService.getStudents();
        Student s = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                s = student;
                break;
            }
        }
        if (s != null) {
            students.remove(s);
            return "success";
        }
        return "failure";
    }

    @PostMapping("/addStudentInfo")
    @ResponseBody
    public String addStu(@RequestBody Student student) {
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