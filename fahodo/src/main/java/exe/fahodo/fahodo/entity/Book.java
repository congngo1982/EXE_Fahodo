package exe.fahodo.fahodo.entity;

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
@Entity(name = "book")
public class Book {
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    private String publicDate;
    private String title;
    @Column(columnDefinition = "NVARCHAR(2000)")
    private String description;
    private double rating;
    private String type;
    private String linkToStore;
    private Long watching;
    private boolean status;
    @OneToMany(mappedBy = "book")
    private List<BookImage> bookImages;

    //    @ManyToMany(mappedBy = "book")
    @OneToMany(mappedBy = "book")
    private List<Comment> comments;
}
