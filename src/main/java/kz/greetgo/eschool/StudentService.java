package kz.greetgo.eschool;

import java.util.List;

public interface StudentService {

    void insert(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void delete(Long id);

}
