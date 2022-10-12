package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping()
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping(path = "{id}")
    public ResponseEntity <Student>getStudent(@PathVariable Long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }
    @PutMapping()
    public ResponseEntity<Student> putStudent(@RequestBody Student student){
        Student student1 = studentService.editStudent(student);
        return ResponseEntity.ok(student1);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(params = "age")
    public ResponseEntity<Collection<Student>> getAgeStudent(@RequestParam(required = false) Integer age){
        return ResponseEntity.ok(studentService.getStudentsAge(age));
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) Integer min,
                                                            @RequestParam(required = false) Integer max){
        return ResponseEntity.ok(studentService.findByAgeBetween(min,max));
    }
    @GetMapping("all")
    public ResponseEntity <Collection<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/{id}/faculty")
    public Faculty getFacultyByStudent(@PathVariable("id") Long id){
        return studentService.getFacultyByStudent(id);
    }
}
