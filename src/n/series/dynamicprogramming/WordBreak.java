package n.series.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * Given a string s and a dictionary of words dict,
 * determine if s can be break into a space-separated sequence of one or more dictionary words.
 * Example
 * Given s = "lintcode", dict = ["lint", "code"].
 * Return true because "lintcode" can be break as "lint code".
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "luckylau";
        Set<String> dict = new HashSet<String>();
        dict.add("lucky");
        dict.add("lau");
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, dict));

    }

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if ((s == null || s.length() == 0) && (dict == null || dict.size() == 0)) {
            return true;
        }
        if (s == null || s.length() == 0) {
            return false;
        }
        int maxLength = getDictMaxLength(dict);
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            f[i] = false;
            for (int lastmaxlength = 1; lastmaxlength <= maxLength && lastmaxlength <= i; lastmaxlength++) {
                if (!f[i - lastmaxlength]) {
                    continue;
                }
                String sub = s.substring(i - lastmaxlength, i);
                if (dict.contains(sub)) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    private int getDictMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String str : dict) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }

}
