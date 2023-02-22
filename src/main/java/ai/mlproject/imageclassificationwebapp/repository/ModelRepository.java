package ai.mlproject.imageclassificationwebapp.repository;

import ai.mlproject.imageclassificationwebapp.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}