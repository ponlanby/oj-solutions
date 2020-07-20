package dfsbfs;

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tongruochen
 * @since 2020/3/25
 */
public class Lc_104_MaximumDepthOfBinaryTree {

    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public int maxDepthDFS(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }
}
