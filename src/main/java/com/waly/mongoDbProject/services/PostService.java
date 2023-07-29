package com.waly.mongoDbProject.services;

import com.waly.mongoDbProject.models.dto.PostDTO;
import com.waly.mongoDbProject.models.entities.Post;
import com.waly.mongoDbProject.repositories.PostRepository;
import com.waly.mongoDbProject.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeParseException;
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
    public List<PostDTO> fullSearch(String text, String start, String end){
        Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
        Instant endMoment = convertMoment(end, Instant.now());

        List<Post> list = repository.fullSearch(text, startMoment, endMoment);
        return list.stream().map(PostDTO::new).toList();
    }

    private Instant convertMoment(String instant, Instant alternative){
        try{
            return Instant.parse(instant);
        }catch (DateTimeParseException e){
            return alternative;
        }
    }
}
