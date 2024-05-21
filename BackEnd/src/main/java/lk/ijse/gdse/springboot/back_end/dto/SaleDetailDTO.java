package lk.ijse.gdse.springboot.back_end.dto;


import lk.ijse.gdse.springboot.back_end.entity.Inventory;
import lk.ijse.gdse.springboot.back_end.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetailDTO {
    private String itemCode;
    private String orderNo;
    private Integer qty;

    private Sale sale;
    private Inventory inventory;
}
