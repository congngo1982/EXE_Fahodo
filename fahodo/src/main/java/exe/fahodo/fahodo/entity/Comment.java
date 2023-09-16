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
@Entity(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account", nullable = false)
    @JsonIgnore
    private Account account;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_comment", joinColumns = @JoinColumn(name = "commentId"),
            inverseJoinColumns = @JoinColumn(name = "bookId"))
    @JsonIgnore
    private List<Book> book;
    private String content;
    private String date;
}
