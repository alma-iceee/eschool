package kz.greetgo.eschool;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(EschoolApplication.class, args);
    }

//    private final StudentMapper studentMapper;
//
//    public EschoolApplication(StudentMapper studentMapper) {
//        this.studentMapper = studentMapper;
//    }
//
//    @Bean
//    CommandLineRunner sampleCommandLineRunner() {
//        return args -> {
//            Student student = new Student();
//            student.setName("Almas");
//            student.setSurname("Sharipkhan");
//            student.setCourse("CSSE-1603");
//            studentMapper.insert(student);
//            System.out.println(this.studentMapper.findAll());
//        };
//    }
}
