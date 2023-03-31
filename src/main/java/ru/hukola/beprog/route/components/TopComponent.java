package ru.hukola.beprog.route.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.hukola.beprog.service.SecurityService;
import ru.hukola.beprog.service.TopComponentService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Babin Nikolay
 * scope prototype because vaadin threw exception when user use logout-login
 */
@Component
@Scope(value = "prototype")
public class TopComponent extends HorizontalLayout {
    private final Map<String, Button> buttons = new HashMap<>();
    public TopComponent(@Autowired SecurityService securityService,
                        @Autowired TopComponentService topComponentService,
                         @Value("${application.title}") String title) {

        H3 logo = new H3(title);
        Button main = new Button("Main", click -> topComponentService.toMainView());
        Button lessons = new Button("Lessons", click -> topComponentService.toLessonsView());
        HorizontalLayout menu = new HorizontalLayout(logo, main, lessons);

        Button logout = new Button("Logout", click -> securityService.logout());
        menu.add(logout);
        add(menu);

        buttons.put("main", main);
        buttons.put("lessons", lessons);
        buttons.put("logout", logout);
    }

    public void setDisabledButton(String key) {
        buttons.forEach((k, v) -> v.setEnabled(true));
        buttons.computeIfPresent(key, (k, b) -> {
            b.setEnabled(false);
            return b;
        });
    }
}
