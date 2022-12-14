package com.sai.dataStructures;

import java.util.Arrays;
import java.util.Stack;

public class TreeTraverse {

    public TreeTraverse() {
    }

    public static void main(String[] main) {
        TreeTraverse t = new TreeTraverse();
        t.init();
    }

    public void init() {
        Node root = createTree();
        traverse(root);
    }

    /* Constructed binary tree is
                       9
                     /   \
                    5     16
                  /  \   /  \
                 3   7  12   18
    */
    public Node createTree() {
        System.out.println("\n");
        System.out.println("=========Tree==========");
        System.out.println("=======================");
        System.out.println("           9 ");
        System.out.println("         /   \\ ");
        System.out.println("        5     16 ");
        System.out.println("      /  \\   /  \\ ");
        System.out.println("     3   7  12   18 ");
        System.out.println("     \\ ");
        System.out.println("      4 ");

        Node n4  = new Node(4, null, null);
        Node n7 = new Node(7, null, null); // Leaf node
        Node n12 = new Node(12, null, null); // Leaf node
        Node n18 = new Node(18, null, null); // Leaf node

        Node n3  = new Node(3, null, n4);
        Node n5 = new Node(5, n3, n7);
        Node n16 = new Node(16, n12, n18);

        Node root = new Node(9, n5, n16);
        return root;
    }

    void traverse(Node root) {
        System.out.print("\n Pre-order traverse (recursive): ");
        preorderRecursive(root);

        System.out.print("\n Pre-order traverse (non-recursive): ");
        preorderNonRecursive(root);

        System.out.print("\n In-order traverse (recursive): ");
        inorderRecursive(root);

        System.out.print("\n In-order traverse (non-recursive): ");
        inorderNonRecursive(root);

        System.out.print("\n Post-order traverse (recursive): ");
        postorderRecursive(root);

        System.out.print("\n Post-order traverse (non-recursive): ");
        postorderNonRecursive(root);

        postorderSai(root);
    }

    void preorderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }

    void preorderNonRecursive(Node node) {
        Stack<Node> stk = new Stack();
        while (node != null || !stk.empty() ) {

            if (node != null) {
                System.out.print(node.data + " ");
                stk.push(node);
                node = node.left;
            }
            if (node == null) {
                node = stk.peek();
                stk.pop();
                node = node.right;
            }
        }
    }


    void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        }
    }

    void inorderNonRecursive(Node node) {
        Stack<Node> stk = new Stack();
        while (node != null || !stk.empty()) {
            if (node != null) {
                stk.push(node);
                node = node.left;
            }
            if (node==null) {
                node = stk.peek();
                stk.pop();
                System.out.print(node.data + " ");
                node = node.right;

            }
        }
    }


    void postorderRecursive(Node node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    void postorderNonRecursive(Node node) {
        Stack<Node> stk = new Stack<Node>();
        Stack<Node> stkDisp = new Stack<>();

        if (node != null) {
            stk.push(node);
        }

        while (!stk.empty()) {
            stkDisp.push(stk.peek());
            stk.pop();

            if (stkDisp.peek().left != null) {
                stk.push(stkDisp.peek().left);
            }

            if (stkDisp.peek().right != null) {
                stk.push(stkDisp.peek().right);
            }
        }

        while (!stkDisp.empty()) {
            System.out.print(stkDisp.peek().data + " ");
            stkDisp.pop();
        }
    }


    void postorderSai(Node node) {
        if (node == null)
            return;

        Stack<Node> stk = new Stack<Node>();
        /*
        Node pre = null;
        while (node!=null || !stk.empty()) {
            if (node!=null) {
                stk.push(node);
                node = node.left;
            }
            else {
                node = stk.peek();
                if (node.right == null || node.right==pre) {
                    System.out.print(node.data + " ");
                    stk.pop();
                    pre = node;
                    node = null;
                }
                else {
                    node = node.right;
                }
            }
        } // while
        // */


        while(true) {
            // while root is not null, push root's right child and root to stack
            // set the root as root's left child
            if (node!= null) {
                if (node.right != null)
                    stk.push(node.right);
                stk.push(node);
                node = node.left;
            }
            else {
                if (stk.empty()) break;

                node = stk.pop();
                // if pop() item have right child and right child on top of stack, then
                // remove the right child from stack, push the root to stack, then
                // set the root as root's right child
                // else print root's data and set root as NULL
                if (node.right != null && node.right.data == stk.peek().data) {

                }
            }
        }



    }

}
