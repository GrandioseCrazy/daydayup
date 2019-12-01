package leetCode;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 0:03 2019/11/18 0018
 * @Others:
 * @Version:1.0
 **/
public class 判断回文数 {
    public static void main(String[] args) {
        System.out.println(issss(1));
    }
    public static boolean issss(int i) {
        if (i < 0 || i ==0) {
            return false;
        }
        int orin = i;
        int temp = 1;
        while (i != 0) {
            if (i == orin) {
                temp = i % 10;
            } else {
                temp = temp * 10 + i % 10;
            }
            i /= 10;
        }
        if (temp == orin) return true;
        return false;
    }
}
