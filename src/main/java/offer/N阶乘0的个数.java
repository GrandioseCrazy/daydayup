package offer;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 23:22 2019/11/16 0016
 * @Others:
 * @Version:1.0
 **/
public class N阶乘0的个数 {
    public static void main(String[] args) {
        System.out.println(getZero(24));
    }
    public static int getZero(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while(temp % 5 == 0 && temp != 0) {
                count ++;
                temp /= 5;
            }
        }
        return count;
    }
}
