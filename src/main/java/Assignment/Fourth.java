package Assignment;

import java.util.*;

// A binary tree Node has value,
class Node {
    int value;
    Node left;
    Node right;

    Node(int x) {
        value = x;
    }
}

class BinaryTreeExample {
    Node root;

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();

            // If current node is NULL, store marker
            if (node == null) {
                list.add("#");
            } else {
                // Else, store current node
                // and recur for its children
                list.add("" + node.value);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return String.join(",", list);
    }

    static int index;

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if (data == null)
            return null;
        index = 0;
        String[] arr = data.split(",");
        return helper(arr);
    }

    public static Node helper(String[] arr) {
        if (arr[index].equals("#"))
            return null;

        // Create node with this item
        // and recur for children
        Node root = new Node(Integer.parseInt(arr[index]));
        index++;
        root.left = helper(arr);
        index++;
        root.right = helper(arr);
        return root;
    }

    // A simple inorder traversal used
    // for testing the constructed tree
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static void main(String args[]) {
        // Construct a tree with different values
        BinaryTreeExample tree = new BinaryTreeExample();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        String serialized = serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Deserialize the stored tree into root1
        Node deserializedRoot = deserialize(serialized);

        System.out.println(
                "Inorder Traversal of the tree constructed"
                        + " from serialized String:");
        inorder(deserializedRoot);
    }

}
