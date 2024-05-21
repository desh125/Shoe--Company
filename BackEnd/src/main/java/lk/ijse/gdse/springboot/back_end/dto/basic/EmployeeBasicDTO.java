package lk.ijse.gdse.springboot.back_end.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBasicDTO {
    private String employeeCode;
    private String name;
    private String email;
}
