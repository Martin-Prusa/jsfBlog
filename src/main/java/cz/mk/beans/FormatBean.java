package cz.mk.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.Renderer;
import org.commonmark.renderer.html.HtmlRenderer;

@ApplicationScoped
@Named
public class FormatBean {
    private Parser parser = Parser.builder().build();
    private HtmlRenderer renderer = HtmlRenderer.builder().build();

    public String mtToHtml(String md) {
        return renderer.render(parser.parse(md));
    }
}
