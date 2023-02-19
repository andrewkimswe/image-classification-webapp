package ai.mlproject.imageclassificationwebapp.repository;

import ai.mlproject.imageclassificationwebapp.domain.Image;
import ai.mlproject.imageclassificationwebapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByUser(User user);
    List<Image> findByCategory(Long categoryId);
}