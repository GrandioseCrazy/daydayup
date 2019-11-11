package offer;

import Util.TreeNode;
import Util.TreeUtil;

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
    // 测试
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        // 构建二叉树
        treeNode1.leftNode = treeNode2;
        treeNode1.rightNode = treeNode3;

        treeNode2.leftNode = treeNode4;
        treeNode2.rightNode = treeNode5;

        treeNode3.leftNode = treeNode6;

        // 求二叉树的镜像
        TreeUtil.preOrder(treeNode1);
        getMirror(treeNode1);
        System.out.println("---------------------------------------------------------");
        TreeUtil.preOrder(treeNode1);
    }
}
