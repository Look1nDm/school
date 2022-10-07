package ru.hogwarts.school.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.models.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
   Collection<Faculty> findFacultyByColor(String color);
}
