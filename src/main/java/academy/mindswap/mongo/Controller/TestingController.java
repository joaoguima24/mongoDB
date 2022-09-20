package academy.mindswap.mongo.Controller;

import academy.mindswap.mongo.Repository.StudentRepository;
import academy.mindswap.mongo.model.Student;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;


public class TestingController {
    private final StudentRepository studentRepository;
    private final MongoTemplate mongoTemplate;

    public TestingController(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        this.studentRepository = studentRepository;
        this.mongoTemplate = mongoTemplate;
    }


    public void createStudentSeed(){
        Student student = new Student(
                "Novo",
                "xx@hotmail.com",
                "Rua",
                "12-12-1991",
                LocalDateTime.now(),
                List.of("Football","Bodyguard")
        );
        addStudentSeedToRepository(student);
    }

    public void addStudentSeedToRepository(Student student){
        studentRepository.findStudentByEmail(student.getEmail())
                .ifPresentOrElse(student1 -> {
                    System.out.println("Invalid email");
                }, ()->{

                    studentRepository.insert(student);
                });
    }

    public void findStudentByID(String id){
        if (studentRepository.findById(id).isEmpty()){
            System.out.println("Id not found"+id);
            return;
        }
        System.out.println(studentRepository.findById(id));
    }

    public void deleteStudentByID(String id){
        if (studentRepository.findById(id).isEmpty()){
            System.out.println("Id not found"+id);
            return;
        }
        System.out.println("Deleted");
        studentRepository.deleteById(id);
    }

    private void queryExample(StudentRepository repository, MongoTemplate mongoTemplate, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is("jotam24@hotmail.com"));
        List<Student> students = mongoTemplate.find(query,Student.class);

        if(students.isEmpty()) {
            repository.insert(student);
        }else {
            System.out.println("Invalid email");
        }
    }
}
