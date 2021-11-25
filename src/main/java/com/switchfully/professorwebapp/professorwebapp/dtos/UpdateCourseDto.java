package com.switchfully.professorwebapp.professorwebapp.dtos;

import com.switchfully.professorwebapp.domain.Professor;

public class UpdateCourseDto {

    private String title;
    private int studyPoints;
    private Professor professor;

    public UpdateCourseDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public UpdateCourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public UpdateCourseDto setProfessor(Professor professor) {
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