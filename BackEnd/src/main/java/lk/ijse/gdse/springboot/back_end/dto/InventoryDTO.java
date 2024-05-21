package lk.ijse.gdse.springboot.back_end.dto;


import lk.ijse.gdse.springboot.back_end.dto.basic.SupplierBasicDTO;
import lk.ijse.gdse.springboot.back_end.entity.SaleDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
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

    private SupplierBasicDTO supplier;
    private List<SaleDetail> saleDetail;
}
