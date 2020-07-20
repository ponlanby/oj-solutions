package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongruochen
 * @since 2020/3/16
 */
public class Lc_145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorderTraversal(node.left, result);
            postorderTraversal(node.right, result);
            result.add(node.val);
        }
    }
}
