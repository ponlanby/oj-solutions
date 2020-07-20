package dfsbfs;

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tongruochen
 * @since 2020/3/25
 */
public class Lc_111_MinimumDepthOfBinaryTree {

    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left == null && node.right == null) {
                    return ++depth;
                }
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

    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepthDFS(root.right);
        }
        if (root.right == null) {
            return 1 + minDepthDFS(root.left);
        }

        return 1 + Math.min(minDepthDFS(root.left), minDepthDFS(root.right));
    }
}
