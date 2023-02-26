package ai.mlproject.imageclassificationwebapp.web;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserForm {

    @NotEmpty(message = "회원 이름은 필수입니다")
    private final String name;

    @NotEmpty
    private final String password;

    @NotEmpty
    private final String email;

}