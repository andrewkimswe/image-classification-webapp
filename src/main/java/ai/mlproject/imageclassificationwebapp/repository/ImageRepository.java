package ai.mlproject.imageclassificationwebapp.repository;

import ai.mlproject.imageclassificationwebapp.domain.Image;
import ai.mlproject.imageclassificationwebapp.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImageRepository {

    private final EntityManager em;

    public void save(Image image) {
        em.persist(image);
    }

    public Image findOne(Long id) {
        return em.find(Image.class, id);
    }

    public List<Image> findAll() {
        return em.createQuery("SELECT i FROM Image i", Image.class).getResultList();
    }

    public List<Image> findByUser(User user) {
        return em.createQuery("SELECT i FROM Image i WHERE i.user = :user", Image.class)
                .setParameter("user", user)
                .getResultList();
    }

    public List<Image> findByCategory(Long categoryId) {
        return em.createQuery("SELECT i FROM Image i WHERE i.category.id = :categoryId", Image.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    public void delete(Long id) {
        Image image = em.find(Image.class, id);
        if (image != null) {
            em.remove(image);
        }
    }
}