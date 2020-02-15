package l.series;
/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */

/**
 * @Author luckylau
 * @Date 2020/1/3
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !isNumOrAlp(chars[start])) {
                start++;
            }
            while (start < end && !isNumOrAlp(chars[end])) {
                end--;
            }
            if (!isEqualWhenToLowerCase(chars[start], chars[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    private boolean isNumOrAlp(char s) {
        return (s >= '0' && s <= '9') || (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z');
    }

    private boolean isEqualWhenToLowerCase(char s, char t) {
        return Character.toLowerCase(s) == Character.toLowerCase(t);
    }
}
