package Util;
/**
* @author: DoubleP
* @Date: 2019/11/11 8:50
* @Description: List的工具类
*/
public class ListUtil {
    /**
     * @Author DoubleP
     * @Description // 遍历输出list的节点
     * @Date 8:52 2019/11/11
     * @Param []
     * @return void
     **/
    public static void print(ListNode head) {
        if (head != null) {
            System.out.println(head.value);
            head = head .next;
            print(head);
        }
    }
}
