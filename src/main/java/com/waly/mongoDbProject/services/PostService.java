package com.waly.mongoDbProject.services;

import com.waly.mongoDbProject.models.dto.PostDTO;
import com.waly.mongoDbProject.models.entities.Post;
import com.waly.mongoDbProject.repositories.PostRepository;
import com.waly.mongoDbProject.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public PostDTO findById(String id) {
        Post post = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found"));
        return new PostDTO(post);
    }

    public List<PostDTO> findByTitle(String text){
        List<Post> list = repository.seachTitle(text);
        return list.stream().map(PostDTO::new).toList();
    }
}
