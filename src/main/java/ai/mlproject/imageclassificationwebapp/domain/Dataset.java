package ai.mlproject.imageclassificationwebapp.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Dataset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false)
    private final List<Image> images;

    public Dataset(String name) {
        this.name = name;
        this.images = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    public List<Image> getImages() {
        return images;
    }

    public int getSize() {
        return images.size();
    }
}