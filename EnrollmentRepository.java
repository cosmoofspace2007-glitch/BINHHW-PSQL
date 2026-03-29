package com.example.product_management.Baiss3;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EnrollmentRepository
{
    private final Map<Integer, Enrollment> db = new HashMap<>();

    public List<Enrollment> findAllEnrollments()
    {
        return new ArrayList<>(db.values());
    }

    public Optional<Enrollment> findEnrollmentById(int id)
    {
//        return db.get(id);
        return Optional.ofNullable(db.get(id));
    }

    public Enrollment createEnrollment(Enrollment enrollment)
    {
        db.put(enrollment.getId(), enrollment);
        return enrollment;
    }

    public Enrollment deleteEnrollment(int id)
    {
//        return db.remove(id);
        Enrollment deleteEnrollment =findEnrollmentById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
        db.remove(id);
        return deleteEnrollment;
    }

    public Enrollment updateEnrollment(int id, Enrollment enrollment)
    {
//        if(!db.containsKey(id))
//        {
//            return  null;
//        }
//        db.put(enrollment.getId(), enrollment);
//        return enrollment;
        Enrollment existingeEnrollment = findEnrollmentById(id).
                orElseThrow(() -> new RuntimeException("Enrollment not found"));

        existingeEnrollment.setStudentName(enrollment.getStudentName());
        return existingeEnrollment;
    }
}
