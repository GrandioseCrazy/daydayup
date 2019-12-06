package leetCode;

import java.util.HashMap;
import java.util.Map;

// 最长回文子串
public class LongestPalindromicSubstring {
    // 给定一个字符串s 找到s中最长的回文子串，你可以假设s的最大长度位1000



    public static String getIt(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().length() == 1) {
            return str;
        }
        if (str.trim().length() == 0) {
            return "";        }
        Map<Integer,String> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                StringBuilder sb = new StringBuilder(str.substring(i,j));
                StringBuilder reverse = sb.reverse();
                if (str.indexOf(reverse.toString())==str.indexOf(sb.toString()) && str.indexOf(sb.toString()) > -1 ) {
                    if (reverse.toString().length() > max) {
                        max = reverse.toString().length();
                        map.put(max,reverse.toString());
                    }
                }
            }
        }
        return map.get(max);
    }



    public static void main(String[] args) {
        getIt("aacdefcaa");
    }
}
