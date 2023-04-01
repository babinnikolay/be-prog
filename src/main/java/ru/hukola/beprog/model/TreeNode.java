package ru.hukola.beprog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@AllArgsConstructor
@Data
public class TreeNode {
    private long id;
    private String name;
    private int deep;
    private String contentPath;
    private List<Lesson> children;
}
