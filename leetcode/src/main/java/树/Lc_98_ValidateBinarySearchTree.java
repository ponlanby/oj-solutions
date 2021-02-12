package 树;

import base.TreeNode;

/**
 * @author tongruochen
 * @since 2020/3/15
 */
public class Lc_98_ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer leftMax = findLeftMax(root);
        Integer rightMin = findRightMin(root);
        if ((leftMax != null && root.val <= leftMax)
                || rightMin != null && root.val >= rightMin) {
            return false;
        } else {
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }

    private static Integer findLeftMax(TreeNode node) {
        TreeNode next = node.left;
        if (next == null) {
            return null;
        }
        Integer max = next.val;
        while (next != null && next.right != null) {
            next = next.right;
            max = next.val;
        }
        return max;
    }

    private static Integer findRightMin(TreeNode node) {
        TreeNode next = node.right;
        if (next == null) {
            return null;
        }
        Integer min = next.val;
        while (next != null && next.left != null) {
            next = next.left;
            min = next.val;
        }
        return min;
    }

    public static void main(String[] args) {
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node10 = new TreeNode(10);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(4);
//
//        TreeNode root = node8;
//        root.left = node6;
//        root.right = node10;
//        node6.left = node3;
//        node6.right = node7;
//        node3.left = node1;
//        node3.right = node4;
//        node10.left = node9;

        TreeNode root = new TreeNode(2147483647);
//        root.left = null;
//        root.right = new TreeNode(2147483647);

        System.out.println(isValidBST(root));
    }
}
