package ai.mlproject.imageclassificationwebapp.service;

import ai.mlproject.imageclassificationwebapp.domain.Result;
import ai.mlproject.imageclassificationwebapp.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    @Transactional
    public Long saveResult(Result result) {
        resultRepository.save(result);
        return result.getId();
    }

    public Result getResultById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public List<Result> getResultsByImage(Long imageId) {
        return resultRepository.findByImageId(imageId);
    }

    public List<Result> getResultsByUser(Long userId) {
        return resultRepository.findByUserId(userId);
    }

    @Transactional
    public void updateResult(Long id, double probability, String predictedLabel) {
        Result result = resultRepository.findById(id).get();
        result = Result.builder()
                .id(result.getId())
                .image(result.getImage())
                .user(result.getUser())
                .probability(probability)
                .predictedLabel(predictedLabel)
                .build();
        resultRepository.save(result);
    }
}