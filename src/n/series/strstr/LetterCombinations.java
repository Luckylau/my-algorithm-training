package n.series.strstr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author luckylau
 * @Date 2022/3/31
 */
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        System.out.println(lc.letterCombinations("2"));

    }

    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> results = new ArrayList<String>();
        if (digits.length() == 0 || digits == null) {
            return results;
        }
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        StringBuffer sb = new StringBuffer();
        helper(map, sb, digits, results);
        return results;
    }

    private void helper(Map<Character, char[]> map, StringBuffer sb, String digits, List<String> results) {
        if (sb.length() == digits.length()) {
            results.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(map, sb, digits, results);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
