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
@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account", nullable = false)
    private Account account;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "book_comment", joinColumns = @JoinColumn(name = "commentId"),
//            inverseJoinColumns = @JoinColumn(name = "bookId"))
    @ManyToOne
    @JoinColumn(name = "book", nullable = true)
    @JsonIgnore
    private Book book;
    private String content;
    private String date;
}
