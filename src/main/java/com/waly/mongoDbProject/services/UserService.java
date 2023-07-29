package com.waly.mongoDbProject.services;

import com.waly.mongoDbProject.models.dto.UserDTO;
import com.waly.mongoDbProject.models.entities.User;
import com.waly.mongoDbProject.repositories.UserRepository;
import com.waly.mongoDbProject.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id) {
        User user= repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        return new UserDTO(user);
    }
}
