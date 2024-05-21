package lk.ijse.gdse.springboot.back_end.dto;

import lk.ijse.gdse.springboot.back_end.dto.basic.EmployeeBasicDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String email;
    private String password;

    private EmployeeBasicDTO employee;
}
