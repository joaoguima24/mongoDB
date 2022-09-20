package academy.mindswap.mongo.Service;

import academy.mindswap.mongo.Repository.StudentRepository;
import academy.mindswap.mongo.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
