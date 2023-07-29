package com.waly.mongoDbProject.models.embedded;

import com.waly.mongoDbProject.models.entities.User;

public class Author {
    private String id;
    private String author;

    public Author(){}

    public Author(String id, String author) {
        id = id;
        author = author;
    }

    public Author(User entity) {
        id = entity.getId();
        author = entity.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
