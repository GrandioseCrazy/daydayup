package leetCode;

import jdk.nashorn.internal.ir.IdentNode;
import org.springframework.util.StringUtils;

/**
 * @Author:pengpeng
 * @Description:
 * @Date: Create in 21:41 2019/11/18 0018
 * @Others:
 * @Version:1.0
 **/
public class StringToNumber {
    public static void main(String[] args) {
        System.out.println(change("+"));
    }

    public static int change(String str){
        if(str == null || str.trim().length() == 0) {
            return 0;
        }
        str =str.trim();
        String tempStr = "";
        boolean isLow = false;
        boolean isHig = true;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(0) == '-' && !isLow) {
                       isLow = true;
                       continue;
                }
                if (str.charAt(0) == '+' && isHig) {
                    isHig = false;
                    continue;
                }
                if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                    tempStr += str.charAt(i);
                } else {
                    if (tempStr.equals("")) {
                        return 0;
                    }else {
                        try {
                            return Integer.parseInt(tempStr) * (isLow?-1:1);
                        } catch (Exception e) {
                            if (str.length() == 1) {
                                return 0;
                            }
                            return isLow? Integer.MIN_VALUE : Integer.MAX_VALUE;
                        }

                    }

                }
            }
        try {
            return Integer.parseInt(tempStr) * (isLow?-1:1);
        } catch (Exception e) {
                if (str.length() == 1) {
                    return 0;
                }
            return isLow? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }


}
