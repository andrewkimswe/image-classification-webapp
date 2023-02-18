package ai.mlproject.imageclassificationwebapp.repository;

import ai.mlproject.imageclassificationwebapp.domain.Result;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResultRepository {

    private final EntityManager em;

    public void save(Result result) {
        em.persist(result);
    }

    public Result findOne(Long id) {
        return em.find(Result.class, id);
    }

    public List<Result> findAll() {
        return em.createQuery("select r from Result r", Result.class).getResultList();
    }

    public List<Result> findByUser(Long userId) {
        return em.createQuery("select r from Result r where r.user.id = :userId", Result.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<Result> findByImage(Long imageId) {
        return em.createQuery("select r from Result r where r.image.id = :imageId", Result.class)
                .setParameter("imageId", imageId)
                .getResultList();
    }

}