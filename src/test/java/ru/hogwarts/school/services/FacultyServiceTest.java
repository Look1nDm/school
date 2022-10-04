package ru.hogwarts.school.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.models.Faculty;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceTest {
    private final FacultyService facultyService = new FacultyService();
    private final HashMap<Long,Faculty> testMap = new HashMap<>(Map.of(2l,new Faculty(2,"Puffenduy","yellow"),
            3l,new Faculty(3,"Slizerine","green"),4l,new Faculty(4,"Kogtevran","blue")));
    @BeforeEach
    void setUp(){
        facultyService.createFaculty(new Faculty(1,"Griffindor","red"));
        facultyService.createFaculty(new Faculty(2,"Puffenduy","yellow"));
        facultyService.createFaculty(new Faculty(3,"Slizerine","green"));
        facultyService.createFaculty(new Faculty(4,"Kogtevran","blue"));
    }

    @Test
    void createFaculty() {
        Faculty extendedFaculty = new Faculty(1,"Griffindor","red");
        assertEquals(testMap.put(1l,extendedFaculty),facultyService.createFaculty(new Faculty(1,"Griffindor","red")));
    }

    @Test
    void findFaculty() {
        Faculty extendedFaculty = new Faculty(2,"Puffenduy","yellow");
        assertEquals(extendedFaculty,facultyService.findFaculty(2));
    }

    @Test
    void editFaculty() {
        Faculty extendedFaculty = new Faculty(2,"Puffenduy","yellow");
        assertEquals(extendedFaculty,facultyService.editFaculty(new Faculty(2,"Puffenduy","yellow")));
    }

    @Test
    void deleteFaculty() {
        Faculty extendedFaculty = new Faculty(2,"Puffenduy","yellow");
        assertEquals(extendedFaculty,facultyService.deleteFaculty(2));
    }

    @Test
    void getFacultyColor() {
        List<Faculty> testGetColor = new ArrayList<>(List.of(new Faculty(2,"Puffenduy","yellow")));
        assertEquals(testGetColor,facultyService.getFacultyColor("yellow"));
    }
}