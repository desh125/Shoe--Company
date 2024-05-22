package lk.ijse.gdse.springboot.back_end.service.impl;

import lk.ijse.gdse.springboot.back_end.dto.SaleDTO;
import lk.ijse.gdse.springboot.back_end.dto.SaleDetailDTO;
import lk.ijse.gdse.springboot.back_end.entity.Inventory;
import lk.ijse.gdse.springboot.back_end.entity.Sale;
import lk.ijse.gdse.springboot.back_end.entity.SaleDetail;
import lk.ijse.gdse.springboot.back_end.repo.InventoryRepo;
import lk.ijse.gdse.springboot.back_end.repo.SaleDetailRepo;
import lk.ijse.gdse.springboot.back_end.repo.SaleRepo;
import lk.ijse.gdse.springboot.back_end.service.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private SaleRepo saleRepo;
    private SaleDetailRepo saleDetailRepo;
    private InventoryRepo inventoryRepo;

    private ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepo saleRepo, SaleDetailRepo saleDetailRepo, InventoryRepo inventoryRepo, ModelMapper modelMapper) {
        this.saleRepo = saleRepo;
        this.saleDetailRepo = saleDetailRepo;
        this.inventoryRepo = inventoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public SaleDTO placeSale(SaleDTO saleDTO) {
        Sale sale = modelMapper.map(saleDTO,Sale.class);
        saleRepo.save(sale);

        //Update inventory qty in inventory entity.
        for (SaleDetail saleDetail: sale.getSaleDetail()){
            Inventory inventory = inventoryRepo.findById(saleDetail.getItemCode()).get();
            inventory.setQty(inventory.getQty()-saleDetail.getQty());
            inventoryRepo.save(inventory);
        }
        return saleDTO;
    }

    @Override
    public List<SaleDTO> getAllOrders() {
        return saleRepo.findAll().stream().map(
                sale -> modelMapper.map(sale, SaleDTO.class)).toList();
    }

    @Override
    public List<SaleDetailDTO> getAllOrderDetails() {
        return saleDetailRepo.findAll().stream().map(
                saleDetail -> modelMapper.map(saleDetail, SaleDetailDTO.class)).toList();
    }
    //Refund Only
    @Override
    public void updateSale(String id, SaleDTO saleDTO) {
        Sale existingSale = saleRepo.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + id));
        modelMapper.map(saleDTO, existingSale);
        saleRepo.save(existingSale);
    }
}
