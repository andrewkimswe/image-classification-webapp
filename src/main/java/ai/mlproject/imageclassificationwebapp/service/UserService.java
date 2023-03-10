package ai.mlproject.imageclassificationwebapp.service;

import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {

        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByName(user.getName());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Transactional
    public void update(Long id, String name) {
        User user = userRepository.findById(id).get();
        user = user.builder().name(name).build();
        userRepository.save(user);
    }

    @Transactional
    public void save(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
    }
}
