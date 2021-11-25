package com.switchfully.professorwebapp.api.dtos.course;

import com.switchfully.professorwebapp.domain.course.Course;
import com.switchfully.professorwebapp.domain.course.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        courseMapper = new CourseMapper();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, path = "{id}")
    public void deleteCourse(@PathVariable String id) {
        courseRepository.deleteCourse(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CourseDto createCourse(@RequestBody CreateCourseDto createCourseDto) {
        Course course = courseMapper.mapToCourse(createCourseDto);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.mapToDto(savedCourse);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, path = "{id}")
    public CourseDto updateCourse(@RequestBody UpdateCourseDto updateCourseDto, @PathVariable String id) {
        Course course = courseRepository.getById(id);
        course.setTitle(updateCourseDto.getTitle());
        course.setProfessor(updateCourseDto.getProfessor());
        course.setStudyPoints(updateCourseDto.getStudyPoints());
        return courseMapper.mapToDto(course);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<CourseDto> getAllCourses() {
        return courseRepository.getAll().stream().map(courseMapper::mapToDto).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "{id}")
    public CourseDto getAllCourses(@PathVariable String id) {
        return courseMapper.mapToDto(courseRepository.getById(id));
    }
}
