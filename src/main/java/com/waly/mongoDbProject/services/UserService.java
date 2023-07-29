package com.waly.mongoDbProject.services;

import com.waly.mongoDbProject.models.dto.PostDTO;
import com.waly.mongoDbProject.models.dto.UserDTO;
import com.waly.mongoDbProject.models.entities.Post;
import com.waly.mongoDbProject.models.entities.User;
import com.waly.mongoDbProject.repositories.PostRepository;
import com.waly.mongoDbProject.repositories.UserRepository;
import com.waly.mongoDbProject.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id) {
        User user= repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        return new UserDTO(user);
    }

    public List<PostDTO> userPosts(String id){
        User user= repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));

        return user.getPosts().stream().map(PostDTO::new).toList();
    }

    public UserDTO insert(UserDTO dto){
        User entity = new User();

        copyDtoToEntity(dto, entity);

        entity = repository.insert(entity);
        return new UserDTO(entity);
    }

    public UserDTO update(UserDTO dto, String id){
        User entity = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("id not found"));

        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }
    public void delete(String id){
        repository.findById(id).orElseThrow(()->new ResourceNotFoundException("id not found"));
        repository.deleteById(id);
    }

    public User copyDtoToEntity(UserDTO dto, User entity){
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
