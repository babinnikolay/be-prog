package ru.hukola.beprog.route;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.hukola.beprog.model.TreeNode;
import ru.hukola.beprog.route.components.TopComponent;
import ru.hukola.beprog.service.SecurityService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Babin Nikolay
 */
@Route("/lessons")
@PermitAll
public class LessonsView extends VerticalLayout {
    private final TopComponent topComponent;

    public LessonsView(@Autowired TopComponent topComponent) {
        this.topComponent = topComponent;
        init();
    }

    private void init() {
        add(topComponent);
        topComponent.setDisabledButton("lessons");
        add("This is lessons view");

        HorizontalLayout body = new HorizontalLayout();
        List<TreeNode> items = new ArrayList<>();
        items.add(new TreeNode("Chapter 1", 1));
        items.add(new TreeNode("Chapter 2", 1));

        TreeGrid<TreeNode> tree = new TreeGrid<>();
        tree.setItems(items, this::getSubs);
        tree.addHierarchyColumn(TreeNode::getName).setHeader("Lesson");
        tree.setWidth("20%");

        Div content = new Div();
        content.add("Text______ ___ _____ ______ ___ __________");

        body.add(tree, content);
        body.setWidth("800px");

        add(body);

    }

    public List<TreeNode> getSubs(TreeNode root) {
        if (root.getDeep() == 2) {
            return Collections.emptyList();
        }
        List<TreeNode> result = new ArrayList<>();
        result.add(new TreeNode("one", 2));
        result.add(new TreeNode("two", 2));
        return result;// List.of(, new TreeNode("two"));
    }
}
