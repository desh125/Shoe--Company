package lk.ijse.gdse.springboot.back_end.dto;


import lk.ijse.gdse.springboot.back_end.entity.Customer;
import lk.ijse.gdse.springboot.back_end.entity.Employee;
import lk.ijse.gdse.springboot.back_end.entity.SaleDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private String orderNo;
    private String customerName;
    private Double total;
    private Date purchaseDate;
    private String paymentMethod;
    private Integer lastDigitsOfCard;
    private Double addedPoints;

    private Customer customer;
    private Employee employee;
    private List<SaleDetail> saleDetail;
}
