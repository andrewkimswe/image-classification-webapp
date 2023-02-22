package ai.mlproject.imageclassificationwebapp.service;

import ai.mlproject.imageclassificationwebapp.domain.Model;
import ai.mlproject.imageclassificationwebapp.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Optional<Model> findById(Long id) {
        return modelRepository.findById(id);
    }

    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    public Model save(Model model) {
        return modelRepository.save(model);
    }

    public void deleteById(Long id) {
        modelRepository.deleteById(id);
    }

}