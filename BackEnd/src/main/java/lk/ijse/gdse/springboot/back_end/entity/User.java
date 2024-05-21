package lk.ijse.gdse.springboot.back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeCode")
    private Employee employee;
}
