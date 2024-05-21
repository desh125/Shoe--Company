package lk.ijse.gdse.springboot.back_end.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
}
