package lk.ijse.gdse.springboot.back_end.entity;

import jakarta.persistence.*;

import lk.ijse.gdse.springboot.back_end.entity.embedded.Address;
import lk.ijse.gdse.springboot.back_end.util.entityUtil.Gender;
import lk.ijse.gdse.springboot.back_end.util.entityUtil.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {
    @Id
    private String employeeCode;
    private String name;
    @Lob
    @Column(name = "profile_pic", columnDefinition = "LONGBLOB")
    private byte[] profilePic;
    private Gender gender;
    private String status;
    private String designation;
    private Role role;
    private Date dateOfBirth;
    private Date dateOfJoin;
    private String branch;
    private Address address;
    private String contactNo;
    private String email;
    private String guardianName;
    private String emergencyContactNo;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Sale> sales;
}
