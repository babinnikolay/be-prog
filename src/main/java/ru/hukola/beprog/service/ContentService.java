package ru.hukola.beprog.service;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @author Babin Nikolay
 */
@Service
public class ContentService {
    private final String contentPath;

    public ContentService(@Value("${application.lessons.path}") String contentPath) {
        this.contentPath = contentPath;
    }

    public VerticalLayout getContent(String file) {
//        String read;
        VerticalLayout result = new VerticalLayout();
        try {
            Path path = Paths.get(ClassLoader.getSystemResource(
                    contentPath + System.getProperty("file.separator") +
                            // file
                    "1/txt/1.txt"
            ).toURI());
            TextArea text = new TextArea();
            text.setValue(Files.readString(path));
            result.add(text);

//            path = Paths.get(ClassLoader.getSystemResource(
//                    contentPath + System.getProperty("file.separator") +
//                            // file
//                            "1/img/1.png"
//            ).toURI());

            StreamResource imageResource = new StreamResource("1.png",
                    () -> getClass().getResourceAsStream("/static/lessons/1/img/1.png"));

            result.add(new Image(imageResource, "alt text"));

//            read = Files.readString(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
//        return read;
        return result;
    }
}
