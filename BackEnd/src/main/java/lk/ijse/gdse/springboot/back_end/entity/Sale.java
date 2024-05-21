package lk.ijse.gdse.springboot.back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Sale {
    @Id
    private String orderNo;
    private String customerName;
    private Double total;
    private Date purchaseDate;
    private String paymentMethod;
    private Integer lastDigitsOfCard;
    private Double addedPoints;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customerCode")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeCode")
    private Employee employee;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetail;
}
