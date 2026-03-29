package com.example.product_management.Baiss3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/instructor")

@Controller
public class instructorController
{
    private final instructorService InstructorService;

    public instructorController(instructorService InstructorService)
    {
        this.InstructorService = InstructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors()
    {
        List<Instructor> li = InstructorService.getInstructors();
        ApiResponse<List<Instructor>> response = new ApiResponse<>(true,"Get all instructors",li);
        return ResponseEntity.ok(response);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable int id)
    {
        Instructor instructor = InstructorService.getInstructorById(id);
//        if(instructor == null)
//            return ResponseEntity.status(404).body(new ApiResponse<>(false,"Get instructor not found",instructor));
//
//        ApiResponse<Instructor>  response = new ApiResponse<>(true,"Get instructor",instructor);
//        return ResponseEntity.ok(response);

        try
        {
            return ResponseEntity
                    .ok(new ApiResponse<>(true,"Get instructor",instructor));
        }
        catch (RuntimeException ex)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false,ex.getMessage(),null));
        }

    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor)
    {
        Instructor createdInstructor = InstructorService.createInstructor(instructor);
        ApiResponse<Instructor> response = new ApiResponse<>(true,"Create instructor success",createdInstructor);
        return ResponseEntity.ok(response);
    }

    @PutMapping({"{/id}"})
    public ResponseEntity<ApiResponse<Instructor>> updateInstrucor(@PathVariable int id,@RequestBody Instructor instructor)
    {
        Instructor instructor1 = InstructorService.updateInstructor(id, instructor);
//        if(instructor1 == null)
//            return ResponseEntity.status(404).body(new ApiResponse<>(false,"can not update instructor",instructor));
//
//        ApiResponse<Instructor>  response = new ApiResponse<>(true,"Update instructor success",instructor1);
//        return ResponseEntity.ok(response);

        try
        {
            return  ResponseEntity
                    .ok(new ApiResponse<>(true,"Update instructor success",instructor1));
        }
        catch (RuntimeException ex)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false,ex.getMessage(),null));
        }
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructor(@PathVariable int id)
    {
        Instructor instructor1 = InstructorService.deleteInstructor(id);
//        if(instructor1 == null)
//            return ResponseEntity.status(404).body(new ApiResponse<>(false,"delete instructor faile",instructor1));
//
//        ApiResponse<Instructor> response = new ApiResponse<>(true,"Delete instructor success",instructor1);
//        return ResponseEntity.ok(response);

        try
        {
            return ResponseEntity
                    .ok(new ApiResponse<>(true,"Delete instructor success",instructor1));
        }
        catch (RuntimeException ex)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false,ex.getMessage(),null));
        }
    }
}
