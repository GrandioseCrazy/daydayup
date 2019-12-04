package leetCode;

import java.util.*;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 11:23 2019/11/24 0024
 * @Others:
 * @Version:1.0
 **/
public class TTTTT {
    public static void main(String[] args) {
        String str1 = "AAAAA";
        String str2 = "AAAAA";
        System.out.println(str1.indexOf(str2));

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
