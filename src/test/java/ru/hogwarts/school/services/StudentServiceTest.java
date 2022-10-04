package ru.hogwarts.school.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private final StudentService studentService = new StudentService();
    private final HashMap<Long, Student> testMap = new HashMap<>(Map.of(2l,new Student(2,"Puffenduy",18),
            3l,new Student(3,"Slizerine",19),4l,new Student(4,"Kogtevran",20)));
    @BeforeEach
    void setUp(){
        studentService.createStudent(new Student(1,"Harry Potter",17));
        studentService.createStudent(new Student(2,"Germiona Greyndger",18));
        studentService.createStudent(new Student(3,"Draco Malfoy",19));
        studentService.createStudent(new Student(4,"Ron Uizly",20));
    }

    @Test
    void createFaculty() {
        Student extendedStudent = new Student(1,"Harry Potter",17);
        assertEquals(testMap.put(1l,extendedStudent),studentService.createStudent(new Student(1,"Vasily Pupkin",17)));
    }

    @Test
    void findFaculty() {
        Student extendedStudent = new Student(1,"Harry Potter",17);
        assertEquals(extendedStudent,studentService.findStudent(1));
    }

    @Test
    void editFaculty() {
        Student extendedStudent = new Student(1,"Harry Potter",17);
        assertEquals(extendedStudent,studentService.editStudent(new Student(1,"Vasily Pupkin",17)));
    }

    @Test
    void deleteFaculty() {
        Student extendedStudent = new Student(1,"Harry Potter",17);
        assertEquals(extendedStudent,studentService.deleteStudent(1));
    }

    @Test
    void getFacultyColor() {
        List<Student> testGetColor = new ArrayList<>(List.of(new Student(2,"Germiona Greyndger",18)));
        assertEquals(testGetColor,studentService.getStudentsAge(18));
    }
}