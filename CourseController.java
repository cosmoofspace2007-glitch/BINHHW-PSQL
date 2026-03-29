package com.example.product_management.Baiss3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/course")

@Controller
public class CourseController
{
    private final CourseService courseService;

    public  CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses()
    {
         List<Course> lc = courseService.getCourses();

        ApiResponse<List<Course>> response =
                new ApiResponse<>(true,"Get all courses success",lc);

        return ResponseEntity.ok(response);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ApiResponse<Course>> getCoursesById(@PathVariable int id)
    {
        Course course = courseService.getCourseById(id);
//        if(course == null)
//        {
//            return ResponseEntity.status(404).body(new ApiResponse<>(false,"Course not found",null));
//        }
//
//        ApiResponse<Course> response =
//                new ApiResponse<>(true,"Get course success",course);
//
//        return ResponseEntity.ok(response);
        try
        {
            return ResponseEntity.
                    ok(new ApiResponse<>(true,"Get course success",courseService.getCourseById(id)));
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false ,e.getMessage(),null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourses(@RequestBody Course  course)
    {
        Course createCourse = courseService.createCourse(course);
        ApiResponse<Course> response =
                new ApiResponse<>(true,"Add course success",createCourse);

        return ResponseEntity.ok(response);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ApiResponse<Course>>  updateCourses(@PathVariable int id,@RequestBody Course  course)
    {
        Course updated = courseService.updateCourse(id, course);
//        if(updated == null)
//        {
//            return ResponseEntity.status(404).body(new ApiResponse<>(false,"Update course failed",null));
//        }
//
//        ApiResponse<Course> response = new ApiResponse<>(true,"Update course success",updated);
//        return ResponseEntity.ok(response);
        try
        {
           return ResponseEntity.
                   ok(new ApiResponse<>(true,"Update course success",updated));
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false ,e.getMessage(),null));
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<ApiResponse<Course>> deleteCourses(@PathVariable int id)
    {
        Course deleted = courseService.deleteCourse(id);
//        if(deleted == null)
//        {
//            return ResponseEntity.status(404).body(new ApiResponse<>(false,"Delete course faile",deleted));
//        }
//
//        ApiResponse<Course>  response = new ApiResponse<>(true,"Delete course success",deleted);
//        return ResponseEntity.ok(response);
        try
        {
            return ResponseEntity.
                    ok(new ApiResponse<>(true,"Delete course success",deleted));
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false ,e.getMessage(),null));
        }
    }
}
