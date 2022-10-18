package ru.hogwarts.school;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.controllers.StudentController;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.repositiries.AvatarRepository;
import ru.hogwarts.school.repositiries.StudentRepository;
import ru.hogwarts.school.services.AvatarService;
import ru.hogwarts.school.services.StudentService;

@WebMvcTest(controllers = StudentController.class)
class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    AvatarRepository avatarRepository;
    @MockBean
    private StudentRepository studentRepository;
    @SpyBean
    AvatarService avatarService;
    @SpyBean
    private StudentService studentService;
    @Autowired
    private ObjectMapper objectMapper;
    String name;
    int age;
    Long id;
    Student student;
    Faculty faculty;

    JSONObject jsonObject;

    @BeforeEach
    void setSettingsByStudent() throws Exception {
        name = "Harry Potter";
        age = 16;
        id = 1l;
        student = new Student(id, name, age);
        faculty = new Faculty(1, "Griffindor", "red");
        jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", name);
        jsonObject.put("age", age);
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        when(studentRepository.findStudentByAge(age)).thenReturn(Collections.singleton(student));
        when(studentRepository.findStudentByFaculty(student)).thenReturn(faculty);
    }

    @Test
    public void testGetStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void testGetStudentByAge() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/student?age=" + age)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(id))
                .andExpect(jsonPath("$[0].name").value(name))
                .andExpect(jsonPath("$[0].age").value(age));
    }
        @Test
        public void testGetStudentByFaculty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/studentId/faculty?id="+id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(id))
                .andExpect(jsonPath("$[0].name").value(name))
                .andExpect(jsonPath("$[0].age").value(age));
    }

    @Test
    public void testPostStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/student")
                        .content(jsonObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void testPutStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/student")
                        .content(jsonObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/student/" + id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
