package tree_traversal_1991;

import java.util.*;

public class Main {
    private static Map<String, TreeNode> tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        tree = new HashMap();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(sc.nextLine());
            String nodeName = tokenizer.nextToken();
            String leftNode = tokenizer.nextToken();
            String rightNode = tokenizer.nextToken();
            tree.put(nodeName, new TreeNode(nodeName, leftNode, rightNode));
        }

        TreeNode root = tree.get("A");
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void preOrder(TreeNode node) {
        System.out.print(node.data);
        if (!node.left.equals(".")) {
            preOrder(tree.get(node.left));
        }
        if (!node.right.equals(".")) {
            preOrder(tree.get(node.right));
        }
    }

    private static void inOrder(TreeNode node) {
        if (!node.left.equals(".")) {
            inOrder(tree.get(node.left));
        }
        System.out.print(node.data);
        if (!node.right.equals(".")) {
            inOrder(tree.get(node.right));
        }
    }

    private static void postOrder(TreeNode node) {
        if (!node.left.equals(".")) {
            postOrder(tree.get(node.left));
        }
        if (!node.right.equals(".")) {
            postOrder(tree.get(node.right));
        }
        System.out.print(node.data);
    }
}

class TreeNode {
    String data;
    String left;
    String right;

    public TreeNode(String data, String left, String right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}