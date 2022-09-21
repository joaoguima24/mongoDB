package academy.mindswap.mongo;

import academy.mindswap.mongo.Controller.TestingController;
import academy.mindswap.mongo.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@SpringBootApplication
@EnableCaching
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(60))
				.disableCachingNullValues()
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
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
