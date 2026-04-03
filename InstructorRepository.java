package Baiss4;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
