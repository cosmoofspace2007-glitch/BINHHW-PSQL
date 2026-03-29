package com.example.product_management.Baiss3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")

@Service
public class CourseService
{
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses()
    {
        return courseRepository.findAllCourses();
    }

    public Course getCourseById(int id)
    {
        return courseRepository.findCourseById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course createCourse(Course course)
    {
        return courseRepository.createCourse(course);
    }

    public Course updateCourse(int id, Course course)
    {
        courseRepository.findCourseById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseRepository.updateCourse(id,course);
    }

    public Course deleteCourse(int id)
    {
        courseRepository.findCourseById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseRepository.deleteCourseById(id);
    }
}
