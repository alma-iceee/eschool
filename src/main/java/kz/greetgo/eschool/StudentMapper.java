package kz.greetgo.eschool;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT id, name, surname, course FROM students")
    List<Student> findAll();

    @Select("SELECT id, name, surname, course FROM students WHERE id = #{id}")
    Student findById(Long id);

    @Insert("INSERT INTO students (name, surname, course) VALUES(#{name}, #{surname}, #{course})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    void deleteStudent(Integer id);

}
