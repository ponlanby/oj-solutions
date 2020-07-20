package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongruochen
 * @since 2020/3/16
 */
public class Lc_144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderTraversal(node.left, result);
            preorderTraversal(node.right, result);
        }
    }
}
