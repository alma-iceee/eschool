package kz.greetgo.eschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void delete(Long id) {
        studentMapper.delete(id);
    }
}
