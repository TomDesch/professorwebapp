package com.switchfully.professorwebapp.domain.course;


import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class CourseRepository {
    private final ConcurrentHashMap<String, Course> CoursesById;

    public CourseRepository() {
        CoursesById = new ConcurrentHashMap<>();
    }

    public Course save(Course Course) {
        CoursesById.put(Course.getId(), Course);
        return Course;
    }

    public Course getById(String id) throws IllegalArgumentException {
        var foundCourse = CoursesById.get(id);
        if (foundCourse == null) {
            throw new IllegalArgumentException("No Course could be found for id " + id);
        }
        return foundCourse;
    }

    public void deleteCourse(String id) throws IllegalArgumentException {
        var foundCourse = CoursesById.get(id);
        if (foundCourse == null) {
            throw new IllegalArgumentException("No Course could be found for id " + id);
        }
        CoursesById.remove(id);
    }

    public Collection<Course> getAll() {return CoursesById.values();}
}
