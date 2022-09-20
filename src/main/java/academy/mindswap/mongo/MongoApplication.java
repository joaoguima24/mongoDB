package academy.mindswap.mongo;

import academy.mindswap.mongo.Controller.TestingController;
import academy.mindswap.mongo.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner (StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			TestingController testingController= new TestingController(repository, mongoTemplate);
			testingController.createStudentSeed();
			testingController.findStudentByID("6328e15512d32543498c769c");
			testingController.findStudentByID("6328e00fd09dbe0205f77");
			testingController.deleteStudentByID("6328e00fd09dbe0205f77954");
		};
	}



}
