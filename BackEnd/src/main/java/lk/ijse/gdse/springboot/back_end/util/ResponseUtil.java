package lk.ijse.gdse.springboot.back_end.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUtil {
    private String state;
    private String message;
    private Object data;
}