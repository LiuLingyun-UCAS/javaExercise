package com.lly.chapter08.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class ThroneInheritance {
    private Node king;
    private Map<String, Node> nodes = new HashMap<>();

    private static class Node {
        String name;
        boolean alive = true;
        Node parent;
        List<Node> children = new ArrayList<>();

        public Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
        }
    }

    public ThroneInheritance(String kingName) {
        king = new Node(kingName, null);
        nodes.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Node p = nodes.get(parentName);
        Node child = new Node(childName, p);
        nodes.put(childName, child);
        p.children.add(child);
    }

    public void death(String name) {
        Node n = nodes.get(name);
        n.alive = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preOrder(king, ans);
        return ans;
    }

    public void preOrder(Node n, List<String> ans) {
        if (n == null) {
            return;
        }
        if (n.alive) {
            ans.add(n.name);
        }
        for (Node child : n.children) {
            preOrder(child, ans);
        }
    }

    public static void main(String[] args) {
        ThroneInheritance king = new ThroneInheritance("king");
        king.birth("king", "andy");
        king.birth("king", "bob");
        king.birth("king", "catherine");
        king.birth("andy", "matthew");
        king.birth("bob", "alex");
        king.birth("bob", "asha");
        System.out.println(king.getInheritanceOrder());
        king.death("bob");
        System.out.println(king.getInheritanceOrder());

    }
}
