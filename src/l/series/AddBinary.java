package l.series;

/**
 * @Author luckylau
 * @Date 2020/4/22
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("101", "110"));

    }

    private String addBinary(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        int len1 = str1.length() - 1;
        int len2 = str2.length() - 1;
        int carry = 0;

        StringBuffer sb = new StringBuffer();

        while (carry == 1 || len1 >= 0 || len2 >= 0) {
            if (len1 >= 0 && str1.charAt(len1--) == '1') {
                carry++;
            }
            if (len2 >= 0 && str2.charAt(len2--) == '1') {
                carry++;
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

}
