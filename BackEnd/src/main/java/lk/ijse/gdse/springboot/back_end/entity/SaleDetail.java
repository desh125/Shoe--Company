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
@IdClass(lk.ijse.gdse.springboot.back_end.entity.SaleDetail_ID.class)
public class SaleDetail{
    @Id
    private String itemCode;
    @Id
    private String orderNo;
    private Integer qty;

    @ManyToOne(cascade = CascadeType.ALL)
    private Sale sale;

    @ManyToOne(cascade = CascadeType.ALL)
    private Inventory inventory;
}
