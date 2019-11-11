package 动态规划;

/* 俩个鸡蛋从100层楼丢下
*  采用动态规划最主要是找到子问题
*  当第一个鸡蛋落下时，要尝试f[i] = 1 + max(i - 1,f[n - 1]) max是为了保证一定能找到
*  i表示尝试的楼数
*
*
* */
public class TwoEggs {

//    static int N = 55;
//    static int M = 1010;
//    static int[][] dp;

    public static void getMin(int m) {

        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m; j++ ) {

            }
        }


    }








}
