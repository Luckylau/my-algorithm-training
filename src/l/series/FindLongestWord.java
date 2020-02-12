package l.series;
/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 * 说明:
 * <p>
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/1/3
 */
public class FindLongestWord {
    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        System.out.println(findLongestWord.findLongestWord("abpcplea", new ArrayList<>(Arrays.asList("a", "b", "c"))));
    }

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str : d) {
            int l1 = res.length();
            int l2 = str.length();
            if (l1 > l2 || (l1 == l2 && res.compareTo(str) < 0)) {
                continue;
            }
            if (isSubString(s, str)) {
                res = str;
            }
        }

        return res;
    }

    private boolean isSubString(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) != target.charAt(j)) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        return j == target.length();

    }
}
