package lk.ijse.gdse.springboot.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPanelDTO {
    private String dataId;
    private Double totalSales;
    private Double totalProfit;
    private String mostSaleItem;
    private String picOfMostSaleItem;
    private Integer mostSaleItemQty;
}
