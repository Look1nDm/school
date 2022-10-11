package ru.hogwarts.school.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
   Faculty findFacultyByColorIgnoreCase(String color);
   Faculty findFacultyByNameIgnoreCase(String name);
   Collection<Student> findFacultiesByStudents(Long numberFaculty);
}
