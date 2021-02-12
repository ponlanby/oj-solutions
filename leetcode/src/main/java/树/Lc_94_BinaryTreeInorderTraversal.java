package 树;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongruochen
 * @since 2020/3/16
 */
public class Lc_94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.val);
            inorderTraversal(node.right, result);
        }
    }
}
