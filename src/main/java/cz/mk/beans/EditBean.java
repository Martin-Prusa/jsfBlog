package cz.mk.beans;

import cz.mk.interfaces.services.IPostsService;
import cz.mk.models.Post;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;

@Named
@RequestScoped
public class EditBean {
    @Inject
    private IPostsService postsService;

    private Post post;

    public void edit() throws IOException {
        this.postsService.editPost(this.post);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }


    public Post getPost() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        Optional<Post> p = this.postsService.getPostById(id);
        if (p.isEmpty()) {
            this.post = new Post();
        } else {
            this.post = p.get();
        }
        return this.post;
    }
}
