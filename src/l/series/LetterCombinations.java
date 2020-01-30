package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/1/30
 */
public class LetterCombinations {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(Arrays.toString(letterCombinations.letterCombinations("23").toArray()));
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        StringBuilder sb = new StringBuilder();
        combination(sb, combinations, digits);
        return combinations;
    }

    private void combination(StringBuilder sb, List<String> combinations, String digits) {
        if (sb.length() == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        int index = digits.charAt(sb.length()) - '0';
        String letter = KEYS[index];
        for (char c : letter.toCharArray()) {
            sb.append(c);
            combination(sb, combinations, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
