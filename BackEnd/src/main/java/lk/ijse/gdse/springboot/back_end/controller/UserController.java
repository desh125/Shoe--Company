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

    // Get all users
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user details by ID
    @GetMapping(params = {"id"})
    public ResponseUtil findUser(@RequestParam String id) {
        return new ResponseUtil("Ok", "Successfully Searched", userService.getUserDetails(id));
    }

    // Save a new user
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return new ResponseUtil("Ok", "Successfully Registered", userDTO);
    }

    // Update an existing user
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return new ResponseUtil("Ok", "Update Success", null);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseUtil deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseUtil("Ok", "User Deleted Successfully", null);
    }
}
