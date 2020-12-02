package kz.greetgo.eschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/")
    public void insert(@RequestBody Student student) {
        studentService.insert(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

}
