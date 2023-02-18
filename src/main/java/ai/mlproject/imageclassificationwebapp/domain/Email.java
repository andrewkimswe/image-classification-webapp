package ai.mlproject.imageclassificationwebapp.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Email {
    private String emailUsername;
    private String emailDomain;

    protected Email() {
    }

    public Email(String emailUsername, String emailDomain) {
        this.emailUsername = emailUsername;
        this.emailDomain = emailDomain;
    }
}