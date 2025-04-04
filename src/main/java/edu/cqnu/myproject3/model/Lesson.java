package edu.cqnu.myproject3.model;

import org.springframework.stereotype.Component;

@Component
public class Lesson {

    private Integer id;
    private String name;

    private String teacher;

    public Lesson() {

    }

    public Lesson(Integer id, String name, String teacher) {
        this.id = id;
        this.name = name;
        this.teacher=teacher;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher= teacher;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", site='" + teacher + '\'' +
                '}';
    }
}

