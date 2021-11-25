package com.switchfully.professorwebapp.api.dtos.course;

import com.switchfully.professorwebapp.domain.course.Course;

public class CourseMapper {
    public CourseDto mapToDto(Course savedCourse) {
        return new CourseDto()
                .setTitle(savedCourse.getTitle())
                .setProfessor(savedCourse.getProfessor())
                .setStudyPoints(savedCourse.getStudyPoints());
    }

    public Course mapToCourse(CreateCourseDto createCourseDto) {
        return new Course(createCourseDto.getTitle(), createCourseDto.getStudyPoints(), createCourseDto.getProfessor());
    }
}
