package lk.ijse.gdse.springboot.back_end.controller;

import lk.ijse.gdse.springboot.back_end.dto.CustomerDTO;
import lk.ijse.gdse.springboot.back_end.entity.Customer;
import lk.ijse.gdse.springboot.back_end.service.CustomerService;
import lk.ijse.gdse.springboot.back_end.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "data/customers")
@CrossOrigin(origins = "http://localhost:63342")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping(params = {"id"})
    public ResponseUtil findCustomer(String id) {
        return new ResponseUtil("Ok", "Successfully Searched", customerService.getCustomerDetails(id));
    }
    @GetMapping(params = {"name"})
    List<CustomerDTO> searchCustomersByName(String name) {
        return customerService.findCustomersByName(name);
    }
    @GetMapping("/NewLoyaltyMember")
    public ResponseUtil getNewID() {
        return new ResponseUtil("Ok", "Successfully Searched", customerService.generateNewID());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }


    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@PathVariable String id,@RequestBody CustomerDTO customerDTO) {
        System.out.println("Update");
        customerService.updateCustomer(id,customerDTO);
        return new ResponseUtil("Ok", "Update Success", null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseUtil deleteCustomer(@PathVariable String id) {
        System.out.println("Delete");
        customerService.deleteCustomer(id);
        return new ResponseUtil("Ok", "Customer Deleted Successfully", null);
    }
}
