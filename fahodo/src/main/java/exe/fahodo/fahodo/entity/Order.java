package exe.fahodo.fahodo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "OrderTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "bookId", nullable = true)
//    @JsonIgnoreProperties({"bookImages", "comments", "author"})
//    private Book book;

    private int bookId;
    private String bookTitle;
    private String username;
    private String name;
    private double totalPrice;
    private int status;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return username + " - " + name + " - " + totalPrice + " - " + address + " - " + phone;
    }
}
