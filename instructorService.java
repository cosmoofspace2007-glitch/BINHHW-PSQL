package com.example.product_management.Baiss3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/instructor")

@Service
public class instructorService
{
    private final instructorRepository InstructorRepository;

    public instructorService(instructorRepository InstructorRepository)
    {
        this. InstructorRepository =  InstructorRepository ;
    }

    public List<Instructor>  getInstructors()
    {
        return InstructorRepository.findAllInstructors();
    }

    public Instructor getInstructorById(int id)
    {
        return InstructorRepository.findInstructorById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    public Instructor createInstructor (Instructor instructor)
    {
        return InstructorRepository.createInstructor(instructor);
    }

    public Instructor updateInstructor (int id, Instructor instructor)
    {
        InstructorRepository.findInstructorById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return InstructorRepository.updateInstructor(id, instructor);
    }

    public Instructor deleteInstructor(int id)
    {
        InstructorRepository.findInstructorById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return InstructorRepository.deleteInstructor(id);
    }
}
