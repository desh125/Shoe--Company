package lk.ijse.gdse.springboot.back_end.dto;


import lk.ijse.gdse.springboot.back_end.dto.basic.UserBasicDTO;
import lk.ijse.gdse.springboot.back_end.entity.Sale;
import lk.ijse.gdse.springboot.back_end.entity.embedded.Address;
import lk.ijse.gdse.springboot.back_end.util.entityUtil.Gender;
import lk.ijse.gdse.springboot.back_end.util.entityUtil.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private String employeeCode;
    private String name;
    private String profilePic;
    private Gender gender;
    private String status;
    private String designation;
    private Role role;
    private Date dateOfBirth;
    private Date dateOfJoin;
    private String branch;
    private Address address;
    private String ContactNo;
    private String email;
    private String guardianName;
    private String EmergencyContactNo;

    private UserBasicDTO user;
    private List<Sale> sales;
}
