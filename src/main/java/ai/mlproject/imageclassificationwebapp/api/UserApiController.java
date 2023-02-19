package ai.mlproject.imageclassificationwebapp.api;

import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/members")
    public CreateUserResponse saveUserV1(@RequestBody @Valid User user) {
        Long id = userService.join(user);
        return new CreateUserResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreateUserResponse saveUserV2(@RequestBody @Valid CreateUserRequest request) {
        User user = User.builder()
                .name(request.getName()).build();
        Long id = userService.join(user);
        return new CreateUserResponse(id);
    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateUserResponse updateUserV2(@PathVariable("id") Long id, @RequestBody @Valid UpdateUserRequest request) {
        userService.update(id, request.getName());
        User findUser = userService.findById(id);
        return new UpdateUserResponse(findUser.getId(), findUser.getName());
    }

    @Data
    static class CreateUserRequest {
        private String name;
    }

    @Data
    static class CreateUserResponse {
        private Long id;

        public CreateUserResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class UpdateUserRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateUserResponse {
        private Long id;
        private String name;
    }

    @GetMapping("/api/v1/members")
    public List<User> membersV1() {
        return userService.findUsers();
    }

    @GetMapping("/api/v2/members")
    public Result membersV2() {
        List<User> findMembers = userService.findUsers();
        List<MemberDto> collect = findMembers.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());
        return new Result(collect);
    }
    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String name;
    }
}