package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    public Faculty postFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @GetMapping({"id"})
    public ResponseEntity<Faculty> getFaculty(@RequestParam long id){
        Faculty faculty = facultyService.findFaculty(id);
        return ResponseEntity.ok(faculty);
    }
    @PutMapping
    public ResponseEntity<Faculty> putFaculty(@RequestBody Faculty faculty){
        Faculty faculty1 = facultyService.editFaculty(faculty);
        return ResponseEntity.ok(faculty1);
    }
    @DeleteMapping(path = "id")
    public ResponseEntity<Faculty> deleteFaculty(@RequestParam long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(path = "color")
    public ResponseEntity<Collection<Faculty>> getColorFaculty (@RequestParam String color){
        return ResponseEntity.ok(facultyService.findFacultyByColor(color));
    }
    @GetMapping(path = "allFaculty")
    public ResponseEntity<Collection<Faculty>> getAllFaculty (){
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }
}
