package m.series.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author luckylau
 * @Date 2021/4/11
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < s.length(); end++) {
            Character tmp = s.charAt(end);
            if (map.containsKey(tmp)) {
                start = Math.max(start, map.get(tmp) + 1);
            }
            res = Math.max(res, end - start + 1);
            map.put(tmp, end);
        }
        return res;
    }
}
