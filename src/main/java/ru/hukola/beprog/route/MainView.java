package ru.hukola.beprog.route;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hukola.beprog.route.components.TopComponent;

/**
 * @author Babin Nikolay
 */
@Route("/")
@PermitAll
public class MainView extends VerticalLayout {
    private final TopComponent topComponent;
    public MainView(@Autowired TopComponent topComponent) {
        this.topComponent = topComponent;
        init();
    }

    private void init() {
        add(topComponent);
        topComponent.setDisabledButton("main");


        add("This is main view");
    }
}
