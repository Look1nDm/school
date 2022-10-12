package ru.hogwarts.school.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.repositiries.StudentRepository;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;
    @Test
    void createStudentTest() {
        Student extendedStudent = new Student(1,"Harry Potter",18);
        Student testStudent = new Student();
        testStudent.setName("Harry Potter");
        testStudent.setAge(18);
        Mockito.when(studentRepository.save(any())).thenReturn(extendedStudent);

        Student actualStudent = studentService.createStudent(extendedStudent);
        assertEquals(extendedStudent,actualStudent);
    }

    @Test
    void findStudentTest() {
        Student extendedStudent = new Student(1,"Harry Potter",17);
        Mockito.when(studentRepository.findById(any())).thenReturn(Optional.of(extendedStudent));
        Student actualStudent = studentService.findStudent(1l);
        assertEquals(extendedStudent,actualStudent);
    }

    @Test
    void editStudentTest() {
        Student extendedStudent = new Student(1,"Harry Potter",17);
        Student studentTest = new Student();
        studentTest.setName("Harry Potter");
        studentTest.setAge(17);
        Mockito.when(studentRepository.save(any())).thenReturn(extendedStudent);
        Student actual = studentRepository.save(studentTest);
        assertEquals(extendedStudent,actual);
    }

//    @Test
//    void deleteStudentTest() {
//        Student extendedStudent = new Student(1,"Harry Potter",17);
//        Mockito.when(studentRepository.deleteById(any())).thenReturn(extendedStudent);
//        assertEquals(studentRepository.deleteById(1l),extendedStudent);
//    }

    @Test
    void getFacultyColor() {
        List<Student> testGetAge = new ArrayList<>(List.of(new Student(2,"Germiona",17)));
        Mockito.when(studentRepository.findStudentByAge(17)).thenReturn(testGetAge);
        assertEquals(testGetAge,studentRepository.findStudentByAge(17));
    }
}