package com.sai.dataStructures;

public class CreateTree {

    public CreateTree() {
    }

    /* Constructed binary tree is
                       9
                     /   \
                    5     16
                  /  \   /  \
                 3   7  12   18
    */
    public static void main(String[] main) {
        Node n3  = new Node(3, null, null); // Leaf node
        Node n7 = new Node(7, null, null); // Leaf node
        Node n12 = new Node(12, null, null); // Leaf node
        Node n18 = new Node(18, null, null); // Leaf node
        Node n5 = new Node(5, n3, n7);
        Node n16 = new Node(16, n12, n18);
        Node root = new Node(9, n5, n16);
    }

}
