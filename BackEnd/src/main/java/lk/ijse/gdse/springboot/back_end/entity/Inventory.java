package lk.ijse.gdse.springboot.back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Inventory {
    @Id
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
    private Integer Qty;

    @ManyToOne
    @JoinColumn(name = "supplierCode")
    private Supplier supplier;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetail;
}
