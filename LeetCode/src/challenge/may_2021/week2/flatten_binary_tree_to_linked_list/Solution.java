package challenge.may_2021.week2.flatten_binary_tree_to_linked_list;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode node) {
        System.out.println(node.val);
        if (node == null) return;

        if (node.left == null && node.right == null) return;

        if (node.left != null) {
            flatten(node.left);
            TreeNode tempNode = node.right;
            node.right = node.left;
            node.left = null;

            TreeNode currentNode = node.right;
            while (currentNode.right != null) {
                currentNode = currentNode.right;
            }
            currentNode.right = tempNode;
        }
        flatten(node.right);
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
