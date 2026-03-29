package com.example.product_management.Baiss3;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CourseRepository
{
    private final Map<Integer, Course> db = new HashMap<>();

    public List<Course> findAllCourses()
    {
        return new ArrayList<>(db.values());
    }

    public Optional<Course> findCourseById(int id)
    {
//        return db.get(id);
        return Optional.ofNullable(db.get(id));
    }

    public Course createCourse(Course course)
    {
        db.put(course.getId(), course);
        return course;
    }

    public Course deleteCourseById(int id)
    {
//        return db.remove(id);
        Course Deletecourse = findCourseById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        db.remove(id);
        return Deletecourse;
    }

    public Course updateCourse(int id,Course course)
    {
//        if(!db.containsKey(id))
//        {
//            return null;
//        }
//        db.put(course.getId(), course);
//        return course;
        Course existingCourse = findCourseById(id).
                orElseThrow(() -> new RuntimeException("Course not found"));

        existingCourse.setTitle(course.getTitle());
        existingCourse.setStatus(course.getStatus());
        return existingCourse;
    }
}

