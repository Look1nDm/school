package ru.hogwarts.school.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.models.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
   Faculty findFacultyByColorIgnoreCase(String color);
   Faculty findFacultyByNameIgnoreCase(String name);
   void findFacultiesByStudents(Long number);
}
