package oussama.it.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institutionName;
    private String institutionAdress;
    private String affiliation;


    @ManyToMany(mappedBy = "membres")
    private List<AuthorGroupe> groups = new ArrayList<>();
}
