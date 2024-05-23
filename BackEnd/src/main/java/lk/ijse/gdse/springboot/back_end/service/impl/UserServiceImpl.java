package lk.ijse.gdse.springboot.back_end.service.impl;

import lk.ijse.gdse.springboot.back_end.dto.UserDTO;
import lk.ijse.gdse.springboot.back_end.dto.UserDTO;
import lk.ijse.gdse.springboot.back_end.entity.User;
import lk.ijse.gdse.springboot.back_end.repo.UserRepo;
import lk.ijse.gdse.springboot.back_end.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(
                users -> modelMapper.map(users, UserDTO.class)).toList();
    }

    @Override
    public UserDTO getUserDetails(String id) {
        if (!userRepo.existsById(id)) throw new RuntimeException("Id not exists !");
        return modelMapper.map(userRepo.findById(id).get(), UserDTO.class);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User userEntity = modelMapper.map(userDTO, User.class);
        User savedUser = userRepo.save(userEntity);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        modelMapper.map(userDTO, existingUser);
        userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("Cannot delete as user does not exist with ID: " + id);
        }
        userRepo.deleteById(id);
    }
}
