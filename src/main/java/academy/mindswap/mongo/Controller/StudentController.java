package academy.mindswap.mongo.Controller;

import academy.mindswap.mongo.Service.StudentService;
import academy.mindswap.mongo.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> listAllStudents(){
        return studentService.getAllStudents();
    }
}
