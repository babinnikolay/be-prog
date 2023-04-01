package ru.hukola.beprog.service;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.treegrid.TreeGrid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hukola.beprog.model.Chapter;
import ru.hukola.beprog.model.TreeNode;
import ru.hukola.beprog.repository.ChapterRepository;

import java.util.Collections;
import java.util.List;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class LessonsService {
    private final ChapterRepository chapterRepository;
    private final ContentService contentService;

    public HorizontalLayout getBody() {
        HorizontalLayout body = new HorizontalLayout();
        body.setWidth("800px");

        HorizontalLayout treeHidePanel = new HorizontalLayout();
        Button treeVisibleButton = new Button("<");
        treeVisibleButton.setMinWidth("5px");
        treeHidePanel.setAlignItems(FlexComponent.Alignment.CENTER);
        treeHidePanel.add(treeVisibleButton);

        TreeGrid<TreeNode> tree = new TreeGrid<>();
        VerticalLayout content = new VerticalLayout();

        List<Chapter> all = chapterRepository.findAll();
        List<TreeNode> items = all.stream()
                .map(c -> new TreeNode(c.getId(), c.getName(), 1, c.getContentPath(), c.getLessons()))
                .toList();

        tree.setItems(items, this::getSubs);
        tree.addHierarchyColumn(TreeNode::getName).setHeader("Lesson");
        tree.setWidth("30%");
        tree.addItemClickListener(n -> {
            body.add(contentService.getContent(n.getItem().getContentPath()));
        });

        content.setWidth("70%");
//        content.setReadOnly(true);

        treeVisibleButton.addClickListener(l -> {
            tree.setVisible(!tree.isVisible());
            l.getSource().setText(tree.isVisible() ? "<" : ">");
        });

        body.add(tree, treeHidePanel, content);
        return body;
    }

    public List<TreeNode> getSubs(TreeNode root) {
        if (root.getDeep() == 2) {
            return Collections.emptyList();
        }
        return root.getChildren().stream()
                .map(l -> new TreeNode(l.getId(), l.getName(), 2, l.getContentPath(), Collections.emptyList()))
                .toList();
    }
}
