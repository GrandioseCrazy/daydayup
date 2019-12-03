package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 11:23 2019/11/24 0024
 * @Others:
 * @Version:1.0
 **/
public class TTTTT {
    public static void main(String[] args) {
//        int a = 0x00FF;
//        int b = 0xF000F;
//        System.out.println(a & b);
//        System.out.println(Integer.toBinaryString(a));
//
//        int r = Integer.reverse(a);
//        System.out.println(r);
//        System.out.println(Integer.toBinaryString(r));
//
//        int rb = Integer.reverseBytes(a);
//        System.out.println(Integer.toHexString(rb));
        Integer i3 =  Integer.valueOf(127);
        Integer i4 =  Integer.valueOf(127);
        System.out.println(i3 == i4);
    }
    public static int minTimeToVisitAllPoints(int[][] arr) {

        if (arr.length <= 1) {
            return 0;
        }
        int count = 0;
        for (int i= 1; i < arr[0].length; i++) {
            count += Math.max(Math.abs(arr[i][0]-arr[i-1][0]),Math.abs(arr[i][1]-arr[i - 1][1]));
        }
        return count;

    }

    public void  say() {
        System.out.println("hello");
    }
}
