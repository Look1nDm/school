package ru.hogwarts.school.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity// указываем что по этому шаблону из БД будут браться значения
public class Student {
    @Id // этому полю присваивается уникальный АДи в базе
    @GeneratedValue// делегируем базе данных присвоение уникального ади каждому созданному элементу
    private long id;
    private String name;
    private int age;
    // убрали конструктор т.к. теперь создание объекта будет доверено базе данных со значениями из нее же
    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
