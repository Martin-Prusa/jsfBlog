package cz.mk.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.Renderer;
import org.commonmark.renderer.html.HtmlRenderer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
@Named
public class FormatBean {
    private Parser parser = Parser.builder().build();
    private HtmlRenderer renderer = HtmlRenderer.builder().build();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public String mtToHtml(String md) {
        return renderer.render(parser.parse(md));
    }

    public String formatDate(LocalDateTime date) {
        return date.format(formatter);
    }
}
