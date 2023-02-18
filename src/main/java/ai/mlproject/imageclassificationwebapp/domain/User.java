package ai.mlproject.imageclassificationwebapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class User {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String password;

    @NotEmpty
    private String name;

    @Embedded
    @JsonIgnore
    private Email email;

    protected User() {

    }

    public User(String name, String password, Email email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    // 밑 두 개 필요한지 의문
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}