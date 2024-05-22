package lk.ijse.gdse.springboot.back_end.service.impl;

import lk.ijse.gdse.springboot.back_end.dto.InventoryDTO;
import lk.ijse.gdse.springboot.back_end.dto.InventoryDTO;
import lk.ijse.gdse.springboot.back_end.entity.Inventory;
import lk.ijse.gdse.springboot.back_end.repo.InventoryRepo;
import lk.ijse.gdse.springboot.back_end.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{
    private InventoryRepo inventoryRepo;
    private ModelMapper modelMapper;

    public InventoryServiceImpl(InventoryRepo inventoryRepo, ModelMapper modelMapper) {
        this.inventoryRepo = inventoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        return inventoryRepo.findAll().stream().map(
                inventories -> modelMapper.map(inventories, InventoryDTO.class)).toList();
    }

    @Override
    public InventoryDTO getInventoryDetails(String id) {
        if (!inventoryRepo.existsById(id)) throw new RuntimeException("Id not exists !");
        return modelMapper.map(inventoryRepo.findById(id).get(), InventoryDTO.class);
    }

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        if (inventoryDTO.getItemCode() == null || inventoryDTO.getItemCode().isEmpty()) {
            inventoryDTO.setItemCode(UUID.randomUUID().toString()); // Generate new UUID only if necessary
        }
        Inventory inventoryEntity = modelMapper.map(inventoryDTO, Inventory.class);
        Inventory savedInventory = inventoryRepo.save(inventoryEntity);
        return modelMapper.map(savedInventory, InventoryDTO.class);
    }

    @Override
    public void updateInventory(String id, InventoryDTO inventoryDTO) {
        Inventory existingInventory = inventoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + id));
        modelMapper.map(inventoryDTO, existingInventory);
        inventoryRepo.save(existingInventory);
    }

    @Override
    public void deleteInventory(String id) {
        if (!inventoryRepo.existsById(id)) {
            throw new RuntimeException("Cannot delete as inventory does not exist with ID: " + id);
        }
        inventoryRepo.deleteById(id);
    }
}
