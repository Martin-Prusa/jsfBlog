package cz.mk.beans;

import cz.mk.interfaces.services.IPostsService;
import cz.mk.models.Post;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.util.Optional;

@RequestScoped
@Named
public class DetailBean {

    @Inject
    private IPostsService postsService;

    public Post getPost() throws IOException {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        Optional<Post> post = this.postsService.getPostById(id);
        if(post.isEmpty()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            return new Post();
        }
        return post.get();
    }
}
