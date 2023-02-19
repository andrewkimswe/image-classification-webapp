package ai.mlproject.imageclassificationwebapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ai.mlproject.imageclassificationwebapp.domain.Image;
import ai.mlproject.imageclassificationwebapp.domain.Result;
import ai.mlproject.imageclassificationwebapp.domain.User;
import ai.mlproject.imageclassificationwebapp.repository.ResultRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ResultServiceTest {

    /*
    @Mock
    private ResultRepository resultRepository;

    @InjectMocks
    private ResultService resultService;

    private User testUser;
    private Image testImage;
    private Result testResult;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create test user
        testUser = User.builder()
                .id(1L)
                .name("testuser")
                .password("testpassword")
                .build();

        // Create test image
        testImage = Image.builder()
                .id(1L)
                .name("Test Image")
                .url("http://testimage.com")
                .description("A test image")
                .user(testUser)
                .build();

        // Create test result
        testResult = Result.builder()
                .id(1L)
                .image(testImage)
                .user(testUser)
                .probability(0.9)
                .predictedLabel("Test Label")
                .build();
    }

    @Test
    public void testSaveResult() {
        // Set up mock repository behavior
        when(resultRepository.save(testResult)).thenReturn(testResult);

        // Call service method
        Long id = resultService.saveResult(testResult);

        // Verify that repository method was called and result ID is returned
        verify(resultRepository, times(1)).save(testResult);
        assertEquals(testResult.getId(), id);
    }

    @Test
    public void testGetResultById() {
        // Set up mock repository behavior
        when(resultRepository.findById(1L)).thenReturn(testResult);

        // Call service method
        Result result = resultService.getResultById(1L);

        // Verify that repository method was called and correct result is returned
        verify(resultRepository, times(1)).findById(1L);
        assertEquals(testResult, result);
    }

    @Test
    public void testGetAllResults() {
        // Set up mock repository behavior
        when(resultRepository.findAll()).thenReturn(Arrays.asList(testResult));

        // Call service method
        List<Result> results = resultService.getAllResults();

        // Verify that repository method was called and correct list of results is returned
        verify(resultRepository, times(1)).findAll();
        assertEquals(1, results.size());
        assertEquals(testResult, results.get(0));
    }

    @Test
    public void testGetResultsByImage() {
        // Set up mock repository behavior
        when(resultRepository.findByImageId(1L)).thenReturn(Arrays.asList(testResult));

        // Call service method
        List<Result> results = resultService.getResultsByImage(1L);

        // Verify that repository method was called and correct list of results is returned
        verify(resultRepository, times(1)).findByImageId(1L);
        assertEquals(1, results.size());
        assertEquals(testResult, results.get(0));
    }

    @Test
    public void testGetResultsByUser() {
        // Set up mock repository behavior
        when(resultRepository.findByUserId(testUser)).thenReturn(Arrays.asList(testResult));

        // Call service method
        List<Result> results = resultService.getResultsByUser(testUser);

        // Verify that repository method was called and correct list of results is returned
        verify(resultRepository, times(1)).findByUserId(testUser);
        assertEquals(1, results.size());
        assertEquals(testResult, results.get(0));
    }

    @Test
    public void testGetResultsByPredictedLabel() {
        // Set up mock repository behavior
        when(resultRepository.findByPredictedLabel("Test Label")).thenReturn(Arrays.asList(testResult));

        // Call service method
        List<Result> results = resultService.getResultsByPredictedLabel("Test Label");

        // Verify that repository method was called and correct list of results is returned
        verify(resultRepository, times(1)).findByPredictedLabel("Test Label");
        assertEquals(1, results.size());
        assertEquals(testResult, results.get(0));
    }

    @Test
    public void testGetResultsByProbabilityGreaterThan() {
        // Set up mock repository behavior
        when(resultRepository.findByProbabilityGreaterThan(0.8)).thenReturn(Arrays.asList(testResult));

        // Call service method
        List<Result> results = resultService.getResultsByProbabilityGreaterThan(0.8);

        // Verify that repository method was called and correct list of results is returned
        verify(resultRepository, times(1)).findByProbabilityGreaterThan(0.8);
        assertEquals(1, results.size());
        assertEquals(testResult, results.get(0));
    }

    @Test
    public void testGetResultsByProbabilityBetween() {
        // Set up mock repository behavior
        when(resultRepository.findByProbabilityBetween(0.8, 0.9)).thenReturn(Arrays.asList(testResult));

        // Call service method
        List<Result> results = resultService.getResultsByProbabilityBetween(0.8, 0.9);

        // Verify that repository method was called and correct list of results is returned
        verify(resultRepository, times(1)).findByProbabilityBetween(0.8, 0.9);
        assertEquals(1, results.size());
        assertEquals(testResult, results.get(0));
    }
*/
}