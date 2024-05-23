package lk.ijse.gdse.springboot.back_end.controller;


import lk.ijse.gdse.springboot.back_end.dto.InventoryDTO;
import lk.ijse.gdse.springboot.back_end.service.InventoryService;
import lk.ijse.gdse.springboot.back_end.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "data/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    //GetALL
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<InventoryDTO> getAllInventory(){
        System.out.println("request received");
        return inventoryService.getAllInventories();
    }

    //GetDetails
    @GetMapping(params = {"id"})
    public ResponseUtil findInventory(String id) {
        return new ResponseUtil("Ok", "Successfully Searched", inventoryService.getInventoryDetails(id));
    }

    //Save
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    InventoryDTO saveInventory(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.saveInventory(inventoryDTO);
    }

    //Update
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateInventory(@PathVariable String id,@RequestBody InventoryDTO inventoryDTO) {
        System.out.println(inventoryDTO);
        inventoryService.updateInventory(id,inventoryDTO);
        return new ResponseUtil("Ok", "Update Success", null);
    }

    //Delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseUtil deleteInventory(@PathVariable String id) {
        System.out.println("Request received to delete Inventory with ID: " + id);
        inventoryService.deleteInventory(id);
        return new ResponseUtil("Ok", "Inventory Deleted Successfully", null);
    }
}
