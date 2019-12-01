package leetCode;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 22:34 2019/11/22 0022
 * @Others:
 * @Version:1.0
 **/
public class Max {
    public static void main(String[] args) {
        rob(new int[]{2,1,1,2});
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 动态规划啊
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = dp[1] > dp[0] ? nums[1] : dp[0];
        int max = 0;
        for (int i = 2 ; i < nums.length; i++) {
            max = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
            dp[i] = max;
        }
        Math.sqrt(5.0);
        return dp[dp.length - 1];

    }
}
