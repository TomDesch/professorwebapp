package com.switchfully.professorwebapp.professorwebapp.dtos;

import com.switchfully.professorwebapp.domain.Professor;

public class CourseDto {
    private String id;
    private String title;
    private int studyPoints;
    private Professor professor;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public Professor getProfessor() {
        return professor;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public CourseDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public CourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public CourseDto setProfessor(Professor professor) {
        this.professor = professor;
        return this;
    }
}
