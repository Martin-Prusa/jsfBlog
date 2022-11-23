package cz.mk.beans;

import cz.mk.interfaces.services.IPostsService;
import cz.mk.models.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class MainBean {
    @Inject
    private IPostsService postsService;

    public void deletePost(String id) {
        this.postsService.deletePost(id);
    }

    public List<Post> getPosts() {
        return postsService.getPosts();
    }
}
