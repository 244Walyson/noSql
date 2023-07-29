package com.waly.mongoDbProject.services;

import com.waly.mongoDbProject.models.dto.PostDTO;
import com.waly.mongoDbProject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


}
