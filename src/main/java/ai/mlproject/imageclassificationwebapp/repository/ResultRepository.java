package ai.mlproject.imageclassificationwebapp.repository;

import ai.mlproject.imageclassificationwebapp.domain.Dataset;
import ai.mlproject.imageclassificationwebapp.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByUserId(Long userId);
    List<Result> findByImageId(Long imageId);

    List<Result> findByImageDataset(Dataset dataset);
    List<Result> findByEvaluationScoreGreaterThanEqual(double score);

}