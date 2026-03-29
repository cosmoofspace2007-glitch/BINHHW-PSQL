package com.example.product_management.Baiss3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollment")

@Service
public class EnrollmentService
{
    private final EnrollmentRepository enrollmentRepository;

    public  EnrollmentService (EnrollmentRepository enrollmentRepository)
    {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment>  getAllEnrollments()
    {
        return enrollmentRepository.findAllEnrollments();
    }

    public Enrollment findEnrollmentById(int id)
    {
        return enrollmentRepository.findEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public Enrollment createEnrollment(Enrollment enrollment)
    {
        return enrollmentRepository.createEnrollment(enrollment);
    }

    public Enrollment updateEnrollment(int id, Enrollment enrollment)
    {
        enrollmentRepository.findEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        return enrollmentRepository.updateEnrollment(id, enrollment);
    }

    public Enrollment deleteEnrollmentById(int id)
    {
        enrollmentRepository.findEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        return enrollmentRepository.deleteEnrollment(id);
    }
}
