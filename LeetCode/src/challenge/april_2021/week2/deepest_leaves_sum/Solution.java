package challenge.april_2021.week2.deepest_leaves_sum;

class Solution {

    private int maxDepth;
    private int sum;

    public int deepestLeavesSum(TreeNode root) {
        findDepth(0, root);

        findSum(0, root);

        return sum;
    }

    private void findSum(int depth, TreeNode node) {
        if (depth == maxDepth) {
            sum += node.val;
            return;
        }
        if (node.left != null) findSum(depth + 1, node.left);
        if (node.right != null) findSum(depth + 1, node.right);
    }

    private void findDepth(int currentDepth, TreeNode node) {
        maxDepth = Math.max(maxDepth, currentDepth);
        if (node.left != null) {
            findDepth(currentDepth + 1, node.left);
        }
        if (node.right != null) {
            findDepth(currentDepth + 1, node.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
