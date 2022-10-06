package ru.hogwarts.school.controllers;

import org.springframework.http.HttpStatus;
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
    @GetMapping({"id"})
    public ResponseEntity <Student>getFaculty(@PathVariable long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }
    @PutMapping()
    public ResponseEntity<Student> putFaculty(Student student){
        Student student1 = studentService.editStudent(student);
        if (student1 == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(student1);
    }
    @DeleteMapping()
    public ResponseEntity<Student> deleteFaculty(long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
//    @GetMapping({"age"})
//    public ResponseEntity<Collection<Student>> getAgeStudent(@PathVariable int age){
//        return ResponseEntity.ok(studentService.getStudentsAge(age));
//    }
    @GetMapping("printAll")
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
