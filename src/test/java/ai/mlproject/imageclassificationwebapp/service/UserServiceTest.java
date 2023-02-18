package ai.mlproject.imageclassificationwebapp.service;

import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception {
        User user = User.builder()
                .name("kim")
                .build();

        Long saveId = userService.join(user);

        Assertions.assertEquals(user, userRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {

        User user1 = User.builder()
                .name("kim")
                .build();

        User user2 = User.builder()
                .name("kim")
                .build();


        userService.join(user1);

        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            userService.join(user2);
        });


        Assertions.fail("예외가 발생해야 한다.");
    }
}
