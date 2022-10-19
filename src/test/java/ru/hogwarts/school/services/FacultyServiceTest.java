package ru.hogwarts.school.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.repositiries.FacultyRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {
    @Mock
    private FacultyRepository facultyRepository;
    @InjectMocks
    private FacultyService facultyService;

    @Test
    void createFaculty() {
        Faculty extendedFaculty = new Faculty();
        extendedFaculty.setId(1);
        extendedFaculty.setName("Griffindor");
        extendedFaculty.setColor("red");

        Faculty testFaculty = new Faculty();
        testFaculty.setName("Griffindor");
        testFaculty.setColor("red");
        Mockito.when(facultyRepository.save(any())).thenReturn(extendedFaculty);

        Faculty actualFaculty = facultyService.createFaculty(testFaculty);
        assertEquals(extendedFaculty,actualFaculty);
    }

    @Test
    void findFaculty() {
        Faculty extendedFaculty = new Faculty();
        extendedFaculty.setId(1);
        extendedFaculty.setName("Griffindor");
        extendedFaculty.setColor("red");
        Mockito.when(facultyRepository.findById(any())).thenReturn(Optional.of(extendedFaculty));
        Faculty actualFaculty = facultyService.findFaculty(1l);
        assertEquals(extendedFaculty,actualFaculty);
    }

    @Test
    void editFaculty() {
        Faculty extendedFaculty = new Faculty(1,"Griffindor","red");
        Faculty testFaculty = new Faculty(1,"Griffindor","red");
        Mockito.when(facultyRepository.save(any())).thenReturn(extendedFaculty);
        assertEquals(extendedFaculty,facultyRepository.save(testFaculty));
    }

    @Test
    void getFacultyColor() {
        Faculty testGetColor = new Faculty(2,"Puffenduy","yellow");
        Mockito.when(facultyRepository.findFacultyByColorIgnoreCase(any())).thenReturn(testGetColor);
        assertEquals(testGetColor,facultyRepository.findFacultyByColorIgnoreCase("yellow"));
    }
}