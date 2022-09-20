package academy.mindswap.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document

public class Student {
    @Id
    private String id;
    private String name;
    @Indexed(unique=true)
    private String email;
    private String address;
    private String dateOfBirth;
    private LocalDateTime created;
    private List<String> hobbies;

    public Student(String name, String email, String address, String dateOfBirth, LocalDateTime created, List<String> hobbies) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.created = created;
        this.hobbies = hobbies;
    }
}
