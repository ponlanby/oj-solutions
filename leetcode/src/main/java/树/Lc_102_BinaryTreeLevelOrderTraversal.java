package 树;

import base.TreeNode;

import java.util.*;

/**
 * @author tongruochen
 * @since 2020/3/24
 */
public class Lc_102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

//        Set<TreeNode> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i=0; i<levelSize; i++) {
                TreeNode node = queue.pollFirst();
                level.add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (result.size() < level+1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        if (node.left != null) {
            dfs(node.left, result, level+1);
        }
        if (node.right != null) {
            dfs(node.right, result, level+1);
        }
    }
}
