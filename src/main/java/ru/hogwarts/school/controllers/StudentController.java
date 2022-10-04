package ru.hogwarts.school.controllers;

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
    public Student getFaculty(@PathVariable long id){
        return studentService.findStudent(id);
    }
    @PutMapping()
    public Student putFaculty(Student student){
        return studentService.editStudent(student);
    }
    @DeleteMapping()
    public Student deleteFaculty(long id){
        return studentService.deleteStudent(id);
    }
    @GetMapping({"age"})
    public Collection<Student> getStudentAge(@PathVariable int age){
        return studentService.getStudentsAge(age);
    }
    @GetMapping("printAll")
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
