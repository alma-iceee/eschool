package kz.greetgo.eschool;

import lombok.Data;

@Data
public class Student {

    private Long id;
    private String name;
    private String surname;
    private String course;

    public Student() {
    }

    public Student(String name, String surname, String course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }
}
