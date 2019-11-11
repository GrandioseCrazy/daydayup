package Util;
/**
* @author: DoubleP
* @Date: 2019/11/11 8:44
* @Description: 树的一个工具类 用于二叉树的各种处理
*/
public class TreeUtil {
    /**
     * @Author DoubleP
     * @Description //前序遍历
     * @Date 8:45 2019/11/11
     * @Param [root]
     * @return void
     **/
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.value);
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }
    /**
     * @Author DoubleP
     * @Description //中序遍历
     * @Date 8:46 2019/11/11
     * @Param [root]
     * @return void
     **/
    public static void inOrder(TreeNode root) {
        inOrder(root.leftNode);
        System.out.println(root.value);
        inOrder(root.rightNode);
    }
    /**
     * @Author DoubleP
     * @Description //后续遍历
     * @Date 8:46 2019/11/11
     * @Param [root]
     * @return void
     **/
    public static void lastOrder(TreeNode root) {
        lastOrder(root.leftNode);
        lastOrder(root.rightNode);
        System.out.println(root.value);
    }
}
