package ai.mlproject.imageclassificationwebapp.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Dataset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "dataset", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Image> images;

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