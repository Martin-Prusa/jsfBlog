package cz.mk.services;

import cz.mk.interfaces.resources.IPostsResource;
import cz.mk.interfaces.services.IPostsService;
import cz.mk.models.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostsService implements IPostsService {

    @Inject
    private IPostsResource postsResource;

    private List<Post> posts;

    @Override
    public void addPost(Post post) {
        this.posts.add(post);
        postsResource.save(posts);
    }

    @Override
    public void editPost(Post post) {
        postsResource.save(posts);
    }

    @Override
    public void deletePost(String id) {
        Optional<Post> post = this.getPostById(id);
        if(post.isEmpty()) return;
        this.posts.remove(post.get());
        postsResource.save(posts);
    }

    public void loadPost() {
        if(posts == null)
           posts = postsResource.load();

    }

    @Override
    public List<Post> getPosts() {
        loadPost();
        return posts;
    }

    @Override
    public Optional<Post> getPostById(String id) {
        loadPost();
        return this.posts.stream().filter(i -> i.getId().equals(id)).findAny();
    }
}
