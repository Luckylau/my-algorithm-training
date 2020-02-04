package l.series;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/1/15
 */
public class DiffWaysToCompute {
    public static void main(String[] args) {
        DiffWaysToCompute diffWaysToCompute = new DiffWaysToCompute();
        System.out.println(diffWaysToCompute.diffWaysToCompute("1+2-3*4"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return ways;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
