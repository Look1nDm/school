package ru.hogwarts.school.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty postFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> putFaculty(@RequestBody Faculty faculty) {
        Faculty faculty1 = facultyService.editFaculty(faculty);
        return ResponseEntity.ok(faculty1);
    }

    @DeleteMapping("/{delete_id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long delete_id) {
        facultyService.deleteFaculty(delete_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color")
    public ResponseEntity<Faculty> getFacultyByColor(@RequestParam String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findFacultyByColor(color));
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name")
    public ResponseEntity<Faculty> getFacultyByName(@RequestParam String name) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(facultyService.findFacultyByName(name));
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/number")
    public ResponseEntity<Collection<Student>> getFacultyByColor(@RequestParam Long number) {
        if (number != null) {
            return ResponseEntity.ok(facultyService.getStudentsOfFaculty(number));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
