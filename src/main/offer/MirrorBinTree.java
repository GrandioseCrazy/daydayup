package offer;

import Util.TreeNode;

/**
 * @Author:pengpeng
 * @Description: 二叉树的镜像
 * @Date: Create in 0:32 2019/11/11 0011
 * @Others:
 * @Version:1.0
 **/
public class MirrorBinTree {
    public static void getMirror(TreeNode root) {
        if (root != null) {
            swapNode(root);
            getMirror(root.leftNode);
            getMirror(root.rightNode);
        }
    }

    private static void swapNode(TreeNode root) {
        TreeNode tempNode = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = tempNode;
    }
}
