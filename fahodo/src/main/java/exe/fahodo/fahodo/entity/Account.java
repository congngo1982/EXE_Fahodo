package exe.fahodo.fahodo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Account")
public class Account {
    @Id
    private String username;
    private String password;
    private String fullName;
    private String birthDate;
    private String email;
    private String gender;
    private String phone;
    private String region;
    private String type;
    private String role;
    private boolean status;

}
