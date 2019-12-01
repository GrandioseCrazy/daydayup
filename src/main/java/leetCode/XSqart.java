package leetCode;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 23:15 2019/11/19 0019
 * @Others:
 * @Version:1.0
 **/
public class XSqart {
    public static void main(String[] args) {
        sqart(4);
    }
    public static int sqart(int x) {
        if (x == 1) {
            return 1;
        }
        int l = 0;
        int right = x;
        int sum = 0;
        while (l < right - 1) {
           int mid = (l + right) / 2;
           if(mid *mid < x) {
               l = mid;
           } else {
               right = mid;
           }
        }
    return l;
        }
    }

