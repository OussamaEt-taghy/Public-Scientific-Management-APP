package oussama.it.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oussama.it.backend.Entities.ENUMs.Decision;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Decision decision;
    private Date reviewdate;
    private String comments;


    @OneToOne
    @JoinColumn(name = "evaluator_id")
    private Evaluator evaluator;


    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;
}
