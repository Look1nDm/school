package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastFaculty = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastFaculty);
        return faculties.put(lastFaculty,faculty);
    }
    public  Faculty findFaculty(long id){
        return faculties.get(id);
    }
    public  Faculty editFaculty(Faculty faculty){
        return faculties.put(faculty.getId(),faculty);
    }
    public  Faculty deleteFaculty(long id){
        return faculties.remove(id);
    }
    public Collection<Faculty> getFacultyColor(String color){
        return faculties.values().stream().
                filter(e->e.getColor().equals(color)).
                collect(Collectors.toList());
    }
}
