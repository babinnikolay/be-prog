package ru.hukola.beprog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Babin Nikolay
 */
@AllArgsConstructor
public
class TreeNode {
    @Getter
    String name;
    @Getter
    int deep;
}
