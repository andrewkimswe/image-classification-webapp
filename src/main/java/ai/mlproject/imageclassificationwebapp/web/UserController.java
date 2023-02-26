package ai.mlproject.imageclassificationwebapp.web;

import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users/new")
    public String createForm(Model model) {
        model.addAttribute("userForm", UserForm.builder().build());
        return "users/createUserForm";
    }

    @PostMapping(value = "/users/new")
    public String create(@Valid UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "users/createUserForm";
        }

        User user = User.builder()
                .name(form.getName())
                .password(form.getPassword())
                .email(form.getEmail())
                .build();

        userService.save(user);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<User> members = userService.findUsers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}