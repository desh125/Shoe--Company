package lk.ijse.gdse.springboot.back_end.dto;


import lk.ijse.gdse.springboot.back_end.entity.Sale;
import lk.ijse.gdse.springboot.back_end.entity.embedded.Address;
import lk.ijse.gdse.springboot.back_end.util.entityUtil.Gender;
import lk.ijse.gdse.springboot.back_end.util.entityUtil.customrtUtil.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    private String customerCode;
    private String name;
    private Gender gender;
    private String contactNo;
    private String email;
    private String joinDate;
    private Address address;
    private Level level;
    private Integer totalPoints;
    private Date dateOfBirth;
    private Timestamp recentPurchase;

    private List<Sale> sales;
}
