package cz.mk.beans;

import cz.mk.interfaces.services.IPostsService;
import cz.mk.models.Post;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class CreateBean {

    @Inject
    private IPostsService postsService;

    private String title;
    private String shortDes;
    private String content;

    public void submitForm() throws IOException {
        this.postsService.addPost(new Post(title, shortDes, content));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
