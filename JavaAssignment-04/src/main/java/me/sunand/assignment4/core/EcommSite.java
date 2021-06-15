package me.sunand.assignment4.core;

public class EcommSite {
    static class Node {
        String data;
        Node children[];

        Node(String data, int n) {
            children = new Node[n];
            this.data = data;
        }
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        int total = root.children.length;
        for (int i = 0; i < total - 1; i++)
            preorder(root.children[i]);
        System.out.println(root.data);
        preorder(root.children[total - 1]);
    }

    public static void search(String s, Node root) {
        if (root == null)
            return;
        int total = root.children.length;
        for (int i = 0; i < total - 1; i++)
            search(s, root.children[i]);
        if (s.equals(root.data))
            System.out.println("Search successful");
        search(s, root.children[total - 1]);
    }

    public static void main(String[] args) {
        int n = 3;
        Node root = new Node("Products", n);
        root.children[0] = new Node("Grocery", n);
        root.children[1] = new Node("Electronics", n);
        root.children[2] = new Node("Personal", n);
        root.children[0].children[0] = new Node("Fruit", n);
        root.children[0].children[1] = new Node("Vegetable", n);
        root.children[1].children[0] = new Node("Phone", n);
        root.children[1].children[1] = new Node("TV", n);
        root.children[1].children[2] = new Node("DVD", n);
        root.children[2].children[0] = new Node("Shampoo", n);
        root.children[2].children[1] = new Node("Perfume", n);
        preorder(root);
        search("Grocery", root);
    }
}
