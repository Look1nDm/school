package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping(path = "id")
    public ResponseEntity <Student>getFaculty(@RequestParam long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }
    @PutMapping()
    public ResponseEntity<Student> putFaculty(@RequestBody Student student){
        Student student1 = studentService.editStudent(student);
        return ResponseEntity.ok(student1);
    }
    @DeleteMapping(path = "id")
    public ResponseEntity<Student> deleteFaculty(@RequestParam long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(path = "age")
    public ResponseEntity<Collection<Student>> getAgeStudent(@RequestParam int age){
        return ResponseEntity.ok(studentService.getStudentsAge(age));
    }
    @GetMapping(path = "allStudent")
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
