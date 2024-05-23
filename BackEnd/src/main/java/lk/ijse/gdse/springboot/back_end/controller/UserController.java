package lk.ijse.gdse.springboot.back_end.controller;

import lk.ijse.gdse.springboot.back_end.dto.UserDTO;
import lk.ijse.gdse.springboot.back_end.service.UserService;
import lk.ijse.gdse.springboot.back_end.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "data/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //GetALL
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getAllSuppliers(){
        System.out.println("request received");
        return userService.getAllUsers();
    }

    //GetDetails
    @GetMapping(params = {"id"})
    public ResponseUtil findSupplier(String id) {
        return new ResponseUtil("Ok", "Successfully Searched", userService.getUserDetails(id));
    }

    //Save
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO saveSupplier(@RequestBody UserDTO supplierDTO){
        return userService.saveUser(supplierDTO);
    }

    //Update
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@PathVariable String id,@RequestBody UserDTO supplierDTO) {
        System.out.println(supplierDTO);
        userService.updateUser(id,supplierDTO);
        return new ResponseUtil("Ok", "Update Success", null);
    }

    //Delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseUtil deleteSupplier(@PathVariable String id) {
        System.out.println("Request received to delete Supplier with ID: " + id);
        userService.deleteUser(id);
        return new ResponseUtil("Ok", "Supplier Deleted Successfully", null);
    }
}
