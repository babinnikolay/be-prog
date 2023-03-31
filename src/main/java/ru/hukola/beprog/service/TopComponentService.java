package ru.hukola.beprog.service;

import com.vaadin.flow.component.UI;
import org.springframework.stereotype.Service;
import ru.hukola.beprog.route.LessonsView;
import ru.hukola.beprog.route.MainView;

/**
 * @author Babin Nikolay
 */
@Service
public class TopComponentService {

    public void toLessonsView() {
        UI.getCurrent().navigate(LessonsView.class);
    }

    public void toMainView() {
        UI.getCurrent().navigate(MainView.class);
    }
}
