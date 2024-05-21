package lk.ijse.gdse.springboot.back_end.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class ContactNo {
    private String contact1;
    private String contact2;
}
