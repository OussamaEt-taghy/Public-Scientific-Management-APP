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
@DiscriminatorValue("AUTH")
public class Corresponding extends User {


  @OneToMany(mappedBy = "correspondingAuthor")
  private List<AuthorGroupe> groups = new ArrayList<>();


  @OneToMany(mappedBy = "corresponding")
  private List<Submission> submissions = new ArrayList<>();
}
