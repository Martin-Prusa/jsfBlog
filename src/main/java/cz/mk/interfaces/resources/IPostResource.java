package cz.mk.interfaces.resources;

import cz.mk.models.Post;

import java.util.List;

public interface IPostResource {
    void save(List<Post> postList);
    List<Post> load();
}
