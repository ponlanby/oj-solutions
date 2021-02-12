package 树;

import base.TreeNode;

/**
 * @author: created by ponlanby
 * @date:2021/1/30
 */
public class Lc_226_翻转二叉树 {

    public TreeNode invertTreeDfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTreeDfs(root.left);
        invertTreeDfs(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    // todo
//    public TreeNode invertTreeBfs(TreeNode root) {
//
//    }
}
