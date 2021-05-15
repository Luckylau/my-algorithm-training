package l.series;

/**
 * @Author luckylau
 * @Date 2020/4/22
 */
public class AddStrings {
    private String addStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        int len1 = str1.length() - 1;
        int len2 = str2.length() - 1;
        int carry = 0;

        StringBuffer sb = new StringBuffer();

        while (carry > 0 || len1 >= 0 || len2 >= 0) {
            int x = len1 < 0 ? 0 : str1.charAt(len1--) - '0';
            int y = len2 < 0 ? 0 : str2.charAt(len2--) - '0';
            sb.append((carry + x + y) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
