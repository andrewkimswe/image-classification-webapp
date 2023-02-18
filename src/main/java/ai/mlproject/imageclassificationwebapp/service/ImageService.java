package ai.mlproject.imageclassificationwebapp.service;

import ai.mlproject.imageclassificationwebapp.domain.Image;
import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    @Transactional
    public Long uploadImage(Image image) {
        imageRepository.save(image);
        return image.getId();
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageById(Long id) {
        return imageRepository.findOne(id);
    }

    public List<Image> getImagesByCategory(Long categoryId) {
        return imageRepository.findByCategory(categoryId);
    }

    public List<Image> getImagesByUser(User user) {
        return imageRepository.findByUser(user);
    }

    @Transactional
    public void updateImage(Long id, String name, String url, String description) {
        Image image = imageRepository.findOne(id);
        image = image.builder().name(name).url(url).description(description).build();
        imageRepository.save(image);
    }

    @Transactional
    public void deleteImage(Long id) {
        imageRepository.delete(id);
    }
}