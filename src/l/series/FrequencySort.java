package l.series;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author luckylau
 * @Date 2020/1/7
 */
public class FrequencySort {
    public static void main(String[] args) {
        String s = "aabadccc";
        FrequencySort frequencySort = new FrequencySort();
        System.out.println(frequencySort.frequencySort(s));
    }

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        ArrayList<Character> buckets[] = new ArrayList[chars.length + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int index = entry.getValue();
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(key);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                ArrayList<Character> list = buckets[i];
                for (Character c : list) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
