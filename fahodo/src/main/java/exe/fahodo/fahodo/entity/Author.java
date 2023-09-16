package exe.fahodo.fahodo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String fullName;
    private String birthDate;
    private String description;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;
}
