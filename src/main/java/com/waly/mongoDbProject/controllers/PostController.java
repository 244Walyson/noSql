package com.waly.mongoDbProject.controllers;

import com.waly.mongoDbProject.models.dto.PostDTO;
import com.waly.mongoDbProject.repositories.PostRepository;
import com.waly.mongoDbProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        PostDTO post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        List<PostDTO> post = service.findByTitle(text);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<PostDTO>> fullseaxrch(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "start", defaultValue = "") String start, @RequestParam(value = "end", defaultValue = "") String end){
        List<PostDTO> post = service.fullSearch(text, start, end);
        return ResponseEntity.ok(post);
    }
}
