package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long lastStudent = 0;

    public Student createStudent(Student student){
        student.setId(++lastStudent);
        return students.put(lastStudent,student);
    }
    public  Student findStudent(long id){
        return students.get(id);
    }
    public  Student editStudent(Student student){
        return students.put(student.getId(),student);
    }
    public  Student deleteStudent(long id){
        return students.remove(id);
    }
    public Collection<Student> getStudentsAge (int age){
        return students.values().stream().
                filter(e->e.getAge()==age).
                collect(Collectors.toList());
    }
    public Collection<Student> getAllStudents(){
        return students.values();
    }
}
