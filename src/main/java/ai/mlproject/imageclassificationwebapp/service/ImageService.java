package ai.mlproject.imageclassificationwebapp.service;

import ai.mlproject.imageclassificationwebapp.domain.Image;
import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void saveImage(Image image, MultipartFile file){
        String uuid = UUID.randomUUID().toString();
    };

    @Transactional
    public Long uploadImage(Image image) {
        imageRepository.save(image);
        return image.getId();
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id).get();
    }

    public List<Image> getImagesByCategory(Long categoryId) {
        return imageRepository.findByCategory(categoryId);
    }

    public List<Image> getImagesByUser(User user) {
        return imageRepository.findByUser(user);
    }

    @Transactional
    public void updateImage(Long id, String name, String url, String description) {
        Image image = imageRepository.findById(id).get();
        image = image.builder().name(name).url(url).description(description).build();
        imageRepository.save(image);
    }

    @Transactional
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}