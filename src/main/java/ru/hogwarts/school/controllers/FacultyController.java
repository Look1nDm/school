package ru.hogwarts.school.controllers;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Faculty> putFaculty(Faculty faculty){
        Faculty faculty1 = facultyService.editFaculty(faculty);
        if (faculty1 == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(faculty);
    }
    @DeleteMapping
    public ResponseEntity<Faculty> deleteFaculty(long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
//    @GetMapping
//    public ResponseEntity<Collection<Faculty>> getColorFaculty (String color){
//        return ResponseEntity.ok(facultyService.getFacultyColor(color));
//    }
    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty (){
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }
}
