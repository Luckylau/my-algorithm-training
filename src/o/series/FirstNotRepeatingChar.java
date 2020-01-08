package o.series;
/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * A-Z,a-z, 65-122
 */

/**
 * @Author luckylau
 * @Date 2019/12/24
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] hash = new int[58];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i] - 65]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (hash[chars[i] - 65] == 1) {
                return i;
            }
        }
        return -1;
    }
}
