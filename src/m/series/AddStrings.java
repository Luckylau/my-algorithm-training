package m.series;

/**
 * 字符串相加
 *
 * @Author luckylau
 * @Date 2021/4/15
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while (l1 >= 0 || l2 >= 0 || carry != 0) {
            int x = l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int y = l2 < 0 ? 0 : num2.charAt(l2) - '0';
            int result = x + y + carry;
            carry = result / 10;
            sb.append(result % 10);
            l1--;
            l2--;
        }
        return sb.reverse().toString();
    }
}
