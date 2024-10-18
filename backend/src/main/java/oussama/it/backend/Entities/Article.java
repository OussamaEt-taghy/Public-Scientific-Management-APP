package oussama.it.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oussama.it.backend.Entities.ENUMs.Types;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Types type;
    private String ArticleSummary;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Keyword_id")
    private List<Keyword> keywords;


    private int wordCount;
    private String content;


    @OneToMany(mappedBy = "article")
    private List<Review> reviews;

    private Date evaluationStartdate;


    @OneToOne(mappedBy = "article")
    private Submission submission;
}
