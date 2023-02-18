package ai.mlproject.imageclassificationwebapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class User {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
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
}