package cz.mk.services;

import cz.mk.interfaces.services.IPostsService;
import cz.mk.models.Post;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostsService implements IPostsService {

    private List<Post> posts = new ArrayList<>();

    @Override
    public void addPost(Post post) {
        this.posts.add(post);
    }

    @Override
    public void editPost(Post post) {

    }

    @Override
    public void deletePost(String id) {
        this.posts.remove(id);
    }

    @Override
    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public Optional<Post> getPostById(String id) {    //idk... zkoušel jsem indexOf atd...
        return null;
    }
}
