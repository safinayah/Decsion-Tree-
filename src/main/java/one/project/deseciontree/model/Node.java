/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayah
 */
public class Node {

    private String id;
    private final List<Node> children = new ArrayList<>();
    private final Node parent;

    public Node(Node parent) {
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public static Node addChild(Node parent, String id) {
        Node node = new Node(parent);
        node.setId(id);
        parent.getChildren().add(node);
        return node;
    }

    public static void printTree(Node node, String appender) {
        System.out.println(appender + node.getId());
        node.getChildren().forEach((each) -> {
            printTree(each, appender + appender);
        });
    }

}
 