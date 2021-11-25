package com.switchfully.professorwebapp.api.dtos.course;

import com.switchfully.professorwebapp.domain.professor.Professor;

public class CreateCourseDto {

    private String title;
    private int studyPoints;
    private Professor professor;

    public CreateCourseDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateCourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public CreateCourseDto setProfessor(Professor professor) {
        this.professor = professor;
        return this;
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
}