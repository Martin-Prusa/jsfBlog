package cz.mk.resources;

import cz.mk.interfaces.resources.IPostsResource;
import cz.mk.models.Post;

import java.util.List;

public class PostsResource implements IPostsResource {
    @Override
    public void save(List<Post> postList) {

    }

    @Override
    public List<Post> load() {
        return null;
    }
}
