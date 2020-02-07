package o.series;

/**
 * @Author luckylau
 * @Date 2019/12/25
 */
public class StrToInt {

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.strToInt("-2147483649"));
    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int start = 0;
        if (str.charAt(start) == ' ') {
            while (str.charAt(start) == ' ') {
                start++;
                if (start >= len) {
                    return 0;
                }
            }
        }
        boolean postive = true;
        if (str.charAt(start) == '+') {
            start++;
        } else if (str.charAt(start) == '-') {
            postive = false;
            start++;
        }
        int pos = start;
        while (pos <= len - 1) {
            if (str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
                pos++;
            } else {
                break;
            }
        }

        if (pos != len) {
            return 0;
        }

        return cal(str, start, postive);
    }

    private int cal(String str, int start, boolean postive) {
        long res = 0;
        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
            res = res * 10 + str.charAt(start) - '0';
            if (postive) {
                if (res > Integer.MAX_VALUE) {
                    return 0;
                }
            } else {
                if (-res < Integer.MIN_VALUE) {
                    return 0;
                }
            }
            start++;
        }
        if (postive) {
            return (int) res;
        } else {
            return (int) -res;
        }
    }
}
