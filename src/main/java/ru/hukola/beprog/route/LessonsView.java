package ru.hukola.beprog.route;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hukola.beprog.route.components.TopComponent;
import ru.hukola.beprog.service.LessonsService;

/**
 * @author Babin Nikolay
 */
@Route("/lessons")
@PermitAll
public class LessonsView extends VerticalLayout {
    private final TopComponent topComponent;
    private final LessonsService lessonsService;

    public LessonsView(@Autowired TopComponent topComponent, 
                       @Autowired LessonsService lessonsService) {
        this.topComponent = topComponent;
        this.lessonsService = lessonsService;
        init();
    }

    private void init() {
        add(topComponent);
        topComponent.setDisabledButton("lessons");
        add(lessonsService.getBody());
    }
}
