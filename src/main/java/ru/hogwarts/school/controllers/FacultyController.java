package ru.hogwarts.school.controllers;

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
    public Faculty getFaculty(@RequestParam long id){
        return facultyService.findFaculty(id);
    }
    @PutMapping
    public Faculty putFaculty(Faculty faculty){
        return facultyService.editFaculty(faculty);
    }
    @DeleteMapping
    public Faculty deleteFaculty(long id){
        return facultyService.deleteFaculty(id);
    }
    @GetMapping({"color"})
    public Collection<Faculty> getFacultyColor(String color){
        return facultyService.getFacultyColor(color);
    }
}
