package lk.ijse.gdse.springboot.back_end.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryBasicDTO {
    private String itemCode;
    private String description;
    private String picture;
    private String category;
    private Integer size;
    private Double buyingPrice;
    private Double salePrice;
    private Double expectProfit;
    private Double profitMargin;
    private String status;
}
