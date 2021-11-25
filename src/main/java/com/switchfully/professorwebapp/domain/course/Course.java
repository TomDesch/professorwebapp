package com.switchfully.professorwebapp.domain.course;

import com.switchfully.professorwebapp.api.dtos.professor.ProfessorController;
import com.switchfully.professorwebapp.domain.professor.Professor;
import com.switchfully.professorwebapp.domain.professor.ProfessorRepository;

import java.util.Objects;
import java.util.UUID;

public class Course {
    private final String id;
    private String title;
    private int studyPoints;
    private Professor professor;
    private static final int STUDY_POINT_RANGE = 6;
    // private static final ProfessorRepository professorReposit
    // todo How to make sure its the same repo used in the prof controller?

    // Check prof exists by id or object based


    public Course(String title, int studyPoints, Professor professor) {
        this.id = UUID.randomUUID().toString(); // What if, somehow, the same UUID is generated twice?
        this.title = title;
        this.studyPoints = validateStudyPointRange(studyPoints);
        this.professor = professor;
    }

    private int validateStudyPointRange(int points) throws IllegalArgumentException {
        if (points < 1 || points > STUDY_POINT_RANGE) {
            throw new IllegalArgumentException("This amount of studypoints needs to be within 1 and "
                    + STUDY_POINT_RANGE + ". The provided amount was: " + points);
        }
        return points;
    }
//
//    private Professor professorIsActive(Professor professor) {
//        if () throw
//    }

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(id, course.id)
                && Objects.equals(title, course.title)
                && Objects.equals(studyPoints, course.studyPoints)
                && Objects.equals(professor, course.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, studyPoints, professor);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + title + '\'' +
                ", studyPoints='" + studyPoints + '\'' +
                ", professor=" + professor +
                '}';
    }
}
