package ai.mlproject.imageclassificationwebapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addImage(Image image) {
        Image newImage = Image.builder()
                .id(image.getId())
                .name(image.getName())
                .url(image.getUrl())
                .category(this)
                .build();
        this.images.add(newImage);
    }
}