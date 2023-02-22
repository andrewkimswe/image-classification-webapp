package ai.mlproject.imageclassificationwebapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Dataset {
    private final String name;
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