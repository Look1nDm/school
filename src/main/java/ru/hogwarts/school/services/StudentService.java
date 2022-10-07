package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.repositiries.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
//    private final HashMap<Long, Student> students = new HashMap<>();
//    private long lastStudent = 0;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public  Student findStudent(long id){
        return studentRepository.findById(id).orElse(null);
    }
    public  Student editStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }
    public Collection<Student> getStudentsAge (int age){
        return studentRepository.findStudentByAge(age);
    }
    public Collection<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
