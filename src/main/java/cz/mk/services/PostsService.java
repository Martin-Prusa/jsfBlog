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
        Optional<Post> post = this.getPostById(id);
        if(post.isEmpty()) return;
        this.posts.remove(post.get());
    }

    @Override
    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public Optional<Post> getPostById(String id) {
        return this.posts.stream().filter(i -> i.getId().equals(id)).findAny();
    }
}
