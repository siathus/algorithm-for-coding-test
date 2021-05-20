package challenge.may_2021.week3.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        Queue<NodeAndLevel> queue = new LinkedList<>();

        queue.offer(new NodeAndLevel(root, 0));

        while (!queue.isEmpty()) {
            NodeAndLevel nodeAndLevel = queue.poll();
            TreeNode currentNode = nodeAndLevel.node;
            int currentLevel = nodeAndLevel.level;

            if (currentNode == null) continue;

            if (currentLevel == levelOrderList.size()) {
                levelOrderList.add(new ArrayList<>());
            }

            List<Integer> currentLevelList = levelOrderList.get(currentLevel);

            currentLevelList.add(currentNode.val);
            queue.offer(new NodeAndLevel(currentNode.left, currentLevel + 1));
            queue.offer(new NodeAndLevel(currentNode.right, currentLevel + 1));
        }

        return levelOrderList;
    }

    class NodeAndLevel {
        TreeNode node;
        int level;

        public NodeAndLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
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
