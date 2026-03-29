package com.example.product_management.Baiss3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/enrollment")

@Controller
public class ErollmentController
{
    private final EnrollmentService enrollmentService;

    public ErollmentController(EnrollmentService enrollmentService)
    {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments()
    {
        List<Enrollment> le = enrollmentService.getAllEnrollments();
        ApiResponse<List<Enrollment>> response =
                new ApiResponse<>(true,"Get all enrollment success",le);

        return ResponseEntity.ok(response);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@RequestParam int id)
    {
        Enrollment e = enrollmentService.findEnrollmentById(id);
//        if(e == null)
//        {
//            return ResponseEntity.status(404).body(new ApiResponse<>(
//                    false, "Enrollment not exits", e));
//        }
//
//        ApiResponse<Enrollment>  response =
//                new ApiResponse<>(true,"Get enrollment success",e);
//        return ResponseEntity.ok(response);
        try
        {
           return ResponseEntity.
                   ok(new ApiResponse<>(true,"Get enrollment success",e));
        }
        catch (RuntimeException a)
        {
            return  ResponseEntity.status(404)
                    .body(new ApiResponse<>(false ,a.getMessage(),null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment)
    {
        Enrollment e = enrollmentService.createEnrollment(enrollment);
        ApiResponse<Enrollment> response =
                new ApiResponse<>(true,"Create enrollment success",e);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping({"/id"})
    public ResponseEntity<ApiResponse<Enrollment>> deleteEnrollment(@PathVariable int id)
    {
        Enrollment e = enrollmentService.deleteEnrollmentById(id);
//        if(e == null)
//            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Cannot delete enrollment", e));
//
//        ApiResponse<Enrollment> response =
//                new ApiResponse<>(true,"Delete enrollment success",e);
//        return ResponseEntity.ok(response);
        try
        {
            return ResponseEntity.ok(new ApiResponse<>(true,"Delete enrollment success",e));
        }
        catch (RuntimeException a)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false ,a.getMessage(),null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable int id,@RequestBody Enrollment enrollment)
    {
        Enrollment e = enrollmentService.updateEnrollment(id, enrollment);
//        if(e == null)
//            return ResponseEntity.status(404).body(new ApiResponse<>(false, "Cannot update enrollment", e));
//
//        ApiResponse<Enrollment>  response =
//                new ApiResponse<>(true,"Update enrollment success",e);
//        return ResponseEntity.ok(response);
        try
        {
            return ResponseEntity.
                    ok(new ApiResponse<>(true,"Update enrollment success",e));
        }
        catch (RuntimeException a)
        {
            return ResponseEntity.status(404)
                    .body(new ApiResponse<>(false ,a.getMessage(),null));
        }
    }
}
