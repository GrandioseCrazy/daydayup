package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 23:48 2019/11/23 0023
 * @Others:
 * @Version:1.0
 **/
    class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().isAnagram("zxcvbnm", "mnbvcxz"));
        }
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            Map<Character,Integer> map1 = new HashMap();
            Map<Character,Integer> map2 = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                if (!map1.containsKey(s.charAt(i))) {
                    map1.put(s.charAt(i),1);
                } else {
                    map1.put(s.charAt(i),map1.get(s.charAt(i)) + 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                if (!map2.containsKey(t.charAt(i))) {
                    map2.put(t.charAt(i),1);
                } else {
                    map2.put(t.charAt(i),map2.get(t.charAt(i) + 1));
                }
            }

            for (int i = 0; i < s.length(); i++) {
                if(map2.get(t.charAt(i))!=map1.get(t.charAt(i)))
                    return false;
            }
            return true;
        }
    }