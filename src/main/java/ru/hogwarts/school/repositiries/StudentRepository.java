package ru.hogwarts.school.repositiries;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;

import java.util.Collection;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student> findStudentByAge(Integer age);

    Collection<Student> findByAgeBetween(Integer min,Integer max);
    Faculty findStudentByFaculty(Student student);
}
