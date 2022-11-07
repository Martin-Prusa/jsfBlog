package cz.mk.interfaces.services;

import cz.mk.models.Post;

import java.util.List;

public interface IPostsService {
    void addPost(Post post);

    void editPost(Post post);

    void deletePost(String id);

    List<Post> getPosts();

    Post getPostById(String id);
}
