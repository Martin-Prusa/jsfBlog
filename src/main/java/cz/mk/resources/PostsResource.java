package cz.mk.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.mk.gson.deserializers.LocalDateTimeDeserializer;
import cz.mk.gson.serializers.LocalDateTimeSerializer;
import cz.mk.interfaces.resources.IPostsResource;
import cz.mk.models.Post;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PostsResource implements IPostsResource {
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .create();

    @Override
    public List<Post> load() {
        List<Post> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("simple-cms-jsf-data.json"));
            String json = br.readLine();
            list = new ArrayList<>(List.of(gson.fromJson(json, Post[].class)));
            br.close();
        } catch (Exception ignored) {}
        return list;
    }

    @Override
    public void save(List<Post> posts) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("simple-cms-jsf-data.json", false));
            bw.write(gson.toJson(posts));
            bw.close();
        } catch (IOException ignored) {}
    }
}
