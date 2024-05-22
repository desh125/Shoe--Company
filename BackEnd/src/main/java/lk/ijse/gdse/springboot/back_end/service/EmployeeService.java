package lk.ijse.gdse.springboot.back_end.service;

import lk.ijse.gdse.springboot.back_end.dto.EmployeeDTO;
import lk.ijse.gdse.springboot.back_end.dto.SupplierDTO;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeDetails(String id);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(String id, EmployeeDTO employeeDTO);
    void deleteEmployee(String id);

    String generateNewID();
    List<EmployeeDTO> findEmployeesByName(String name);
}
