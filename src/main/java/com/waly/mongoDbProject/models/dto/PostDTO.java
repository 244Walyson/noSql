package com.waly.mongoDbProject.models.dto;

import com.waly.mongoDbProject.models.embedded.Author;
import com.waly.mongoDbProject.models.embedded.Comment;
import com.waly.mongoDbProject.models.entities.Post;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {

    private String id;
    private Instant moment;
    private String title;
    private String body;

    private Author author;

    private List<Comment> comments = new ArrayList<>();

    public PostDTO(){}

    public PostDTO(String id, Instant moment, String title, String body, Author author, List<Comment> comments) {
        this.id = id;
        this.moment = moment;
        this.title = title;
        this.body = body;
        this.author = author;
        this.comments = comments;
    }

    public PostDTO(Post entitty){
        this.id = entitty.getId();
        this.moment = entitty.getMoment();
        this.title = entitty.getTitle();
        this.body = entitty.getBody();
        this.author = entitty.getAuthor();
        this.comments = entitty.getComments();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
