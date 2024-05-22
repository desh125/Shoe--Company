package lk.ijse.gdse.springboot.back_end.service;

import lk.ijse.gdse.springboot.back_end.dto.SaleDTO;
import lk.ijse.gdse.springboot.back_end.dto.SaleDetailDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SaleService {
    SaleDTO placeSale(@RequestBody SaleDTO saleDTO);

    List<SaleDTO> getAllOrders();

    List<SaleDetailDTO> getAllOrderDetails();

    void updateSale(String id, SaleDTO saleDTO);
}
