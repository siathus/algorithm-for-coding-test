package challenge.may_2021.week3.binary_tree_cameras;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private int count = 0;

    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? count + 1 : count;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 1;

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 || right == 0) {
            count++;
            return 2;
        } else if (left == 2 || right == 2) return 1;
        else return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
