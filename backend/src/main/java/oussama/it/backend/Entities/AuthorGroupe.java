package oussama.it.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorGroupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="correspondingAuthor_id")
    private Corresponding correspondingAuthor;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_group_author",
            joinColumns = @JoinColumn(name = "author_group_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> membres = new ArrayList<>();

}
