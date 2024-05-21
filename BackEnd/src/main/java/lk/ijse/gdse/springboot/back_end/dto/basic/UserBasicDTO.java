package lk.ijse.gdse.springboot.back_end.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicDTO {
    private String email;
    private String password;
}
