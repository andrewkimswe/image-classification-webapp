package ai.mlproject.imageclassificationwebapp.domain;

import jakarta.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false)
    private final String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "label_id")
    private final Label label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dataset_id")
    private final Dataset dataset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluation_id")
    private final Evaluation evaluation;

    protected Model() {
        this.name = null;
        this.description = null;
        this.label = null;
        this.dataset = null;
        this.evaluation = null;
    }

    public Model(String name, String description, Label label, Dataset dataset, Evaluation evaluation) {
        this.name = name;
        this.description = description;
        this.label = label;
        this.dataset = dataset;
        this.evaluation = evaluation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Label getLabel() {
        return label;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public Evaluation getEvaluation() {return evaluation;}

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", label=" + label +
                ", dataset= " + dataset +
                ", evaluation= " + evaluation +
                '}';
    }
}