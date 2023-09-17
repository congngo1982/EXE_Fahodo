package exe.fahodo.fahodo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transactionService")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnore
    private Account account;
    private String payment;
    private double total;
    private String createdOn;
    private String voucher;
    private String detail;
    private boolean status;
}
