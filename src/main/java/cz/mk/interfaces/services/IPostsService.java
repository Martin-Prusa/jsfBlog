package cz.mk.interfaces.services;

import cz.mk.models.Post;

import java.util.List;
import java.util.Optional;

public interface IPostsService {
    void addPost(Post post);

    void editPost(Post post);

    void deletePost(String id);

    List<Post> getPosts();

    Optional<Post> getPostById(String id);
}
