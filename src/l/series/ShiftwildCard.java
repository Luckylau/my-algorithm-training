package l.series;

/**
 * 将字符串中的*移到前面，保持字符串原有顺序
 */
public class ShiftwildCard {

    public static void main(String[] args) {
        ShiftwildCard shiftwildCard = new ShiftwildCard();
        String str = "ab**cd**e*12";
        System.out.println(shiftwildCard.shiftWildCard(str));

    }

    public String shiftWildCard(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int i = str.length() - 1;
        int j = str.length() - 1;
        while (i >= 0) {
            if (chars[i] != '*') {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return String.valueOf(chars);
    }

}
