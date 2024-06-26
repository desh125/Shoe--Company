package lk.ijse.gdse.springboot.back_end.service;

import lk.ijse.gdse.springboot.back_end.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findCustomersByName(String name);
    String generateNewID();
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerDetails(String id);
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String id);
}
