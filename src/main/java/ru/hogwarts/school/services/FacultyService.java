package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.repositiries.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;// подрубаем полиморфизм и теперь репозитории будут прослойками
    // между базой данных и сервисами , хотя методы в интерфейсах репозиторий мы не указывали, но нужные методы наследуются
    // от интерфейса JpaRepository

    //private final HashMap<Long, Faculty> faculties = new HashMap<>();
    //private long lastFaculty = 0;
// Элементы выше больше не нужны - мапа заменяется на базу данных , а адишник на уникальный айди при создании и занесении в базу
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
// таблица с запросами висит на стене!!!
    public Faculty createFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public  Faculty findFaculty(long id){
        return facultyRepository.findById(id).orElse(null);
    }
    public  Faculty editFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty(long id){
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> findFacultyByColor(String color){
        return facultyRepository.findFacultyByColor(color);
    }
    public Collection<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }
}
