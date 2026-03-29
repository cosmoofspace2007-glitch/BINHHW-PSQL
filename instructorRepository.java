package com.example.product_management.Baiss3;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class instructorRepository
{
    public final Map<Integer, Instructor> db =  new HashMap<>();

    public List<Instructor> findAllInstructors()
    {
        return new ArrayList<>(db.values());
    }

    public Optional<Instructor> findInstructorById(int id)
    {
//        return db.get(id);
        return Optional.ofNullable(db.get(id));
    }

    public Instructor createInstructor(Instructor instructor)
    {
        db.put(instructor.getId(), instructor);
        return instructor;
    }

    public Instructor updateInstructor(int id, Instructor instructor)
    {
//        if(!db.containsKey(id))
//        {
//            return  null;
//        }
//        db.put(id, instructor);
//        return instructor;
        Instructor existingInstructor = findInstructorById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        existingInstructor.setInstructorEmail(instructor.getInstructorEmail());
        existingInstructor.setInstructorName(instructor.getInstructorName());
        return existingInstructor;
    }

    public Instructor deleteInstructor(int id)
    {
//        return db.remove(id);
        Instructor deleteInstructor  = findInstructorById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        db.remove(id);
        return deleteInstructor;
    }
}
