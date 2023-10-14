package exe.fahodo.fahodo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book_images")
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Source;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "books", nullable = false)
    @JsonIgnore
    private Book book;

    private String type;
}
