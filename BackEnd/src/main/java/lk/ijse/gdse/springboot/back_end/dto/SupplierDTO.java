package lk.ijse.gdse.springboot.back_end.dto;


import lk.ijse.gdse.springboot.back_end.dto.basic.InventoryBasicDTO;
import lk.ijse.gdse.springboot.back_end.entity.embedded.Address;
import lk.ijse.gdse.springboot.back_end.entity.embedded.ContactNo;
import lk.ijse.gdse.springboot.back_end.util.entityUtil.supplierUtil.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private String supplierCode;
    private String name;
    private Category category;
    private Address address;
    private ContactNo contactNo;
    private String email;

    private List<InventoryBasicDTO> inventoryItems;
}
