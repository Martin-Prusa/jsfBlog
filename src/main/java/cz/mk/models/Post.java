package cz.mk.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private String id;
    private LocalDateTime createdAt;
    private String title;
    private String description;
    private String content;

    public Post(String title, String description, String content) {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Post() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.title = "";
        this.description = "";
        this.content = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
