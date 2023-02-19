package ai.mlproject.imageclassificationwebapp.service;

import ai.mlproject.imageclassificationwebapp.domain.Category;
import ai.mlproject.imageclassificationwebapp.domain.Image;
import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.repository.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ImageServiceTest {

    private ImageService imageService;

    @Mock
    private ImageRepository imageRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        imageService = new ImageService(imageRepository);
    }

    @Test
    public void testUploadImage() {
        Image image = Image.builder()
                .id(1L)
                .name("Test Image")
                .url("http://testimage.com")
                .description("A test image")
                .user(User.builder().id(1L).build())
                .category(Category.builder().id(1L).build())
                .build();

        doNothing().when(imageRepository).save(image);

        Long id = imageService.uploadImage(image);
        verify(imageRepository, times(1)).save(image);
        assertEquals(1L, id);
    }

    @Test
    public void testGetAllImages() {
        List<Image> images = Arrays.asList(
                Image.builder()
                        .id(1L)
                        .name("Test Image 1")
                        .url("http://testimage1.com")
                        .description("A test image 1")
                        .user(User.builder().id(1L).build())
                        .category(Category.builder().id(1L).build())
                        .build(),
                Image.builder()
                        .id(2L)
                        .name("Test Image 2")
                        .url("http://testimage2.com")
                        .description("A test image 2")
                        .user(User.builder().id(1L).build())
                        .category(Category.builder().id(2L).build())
                        .build()
        );
        when(imageRepository.findAll()).thenReturn(images);

        List<Image> allImages = imageService.getAllImages();
        verify(imageRepository, times(1)).findAll();
        assertEquals(2, allImages.size());
        assertEquals(images.get(0).getName(), allImages.get(0).getName());
        assertEquals(images.get(1).getName(), allImages.get(1).getName());
    }

    @Test
    public void testGetImageById() {
        Image image = Image.builder()
                .id(1L)
                .name("Test Image")
                .url("http://testimage.com")
                .description("A test image")
                .user(User.builder().id(1L).build())
                .category(Category.builder().id(1L).build())
                .build();
        Optional<Image> optionalImage = Optional.of(image);
        when(imageRepository.findById(1L)).thenReturn(optionalImage);

        Image result = imageService.getImageById(1L);
        verify(imageRepository, times(1)).findById(1L);
        assertEquals("Test Image", result.getName());
    }

    @Test
    public void testGetImagesByCategory() {
        List<Image> images = Arrays.asList(
                Image.builder()
                        .id(1L)
                        .name("Test Image 1")
                        .url("http://testimage1.com")
                        .description("A test image 1")
                        .user(User.builder().id(1L).build())
                        .category(Category.builder().id(1L).name("Test Category").build())
                        .build(),
                Image.builder()
                        .id(2L)
                        .name("Test Image 2")
                        .url("http://testimage2.com")
                        .description("A test image 2")
                        .user(User.builder().id(2L).build())
                        .category(Category.builder().id(1L).name("Test Category").build())
                        .build(),
                Image.builder()
                        .id(3L)
                        .name("Test Image 3")
                        .url("http://testimage3.com")
                        .description("A test image 3")
                        .user(User.builder().id(3L).build())
                        .category(Category.builder().id(2L).name("Other Category").build())
                        .build()
        );

        when(imageRepository.findByCategory(1L)).thenReturn(images.subList(0, 2));
        List<Image> result = imageService.getImagesByCategory(1L);

        assertEquals(2, result.size());
        assertEquals("Test Image 1", result.get(0).getName());
        assertEquals("Test Image 2", result.get(1).getName());
    }
}