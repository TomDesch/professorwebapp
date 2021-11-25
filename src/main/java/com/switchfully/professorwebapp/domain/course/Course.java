package com.switchfully.professorwebapp.domain.course;

import com.switchfully.professorwebapp.domain.professor.Professor;

import java.util.Objects;
import java.util.UUID;

public class Course {
    private final String id;
    private String title;
    private int studyPoints;
    private Professor professor;

    // todo make it so theres only 1 -6 SP available
    // Check prof exists by id or object based


    public Course(String title, int studyPoints, Professor professor) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.studyPoints = studyPoints;
        this.professor = professor;
    }

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
