package com.grade.project.infrastructure.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String pass;
    private String role;
}
