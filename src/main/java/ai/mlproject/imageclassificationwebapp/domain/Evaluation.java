package ai.mlproject.imageclassificationwebapp.domain;

import jakarta.persistence.*;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    private double accuracy;

    private double precision;

    private double recall;

    // constructors, getters and setters
}