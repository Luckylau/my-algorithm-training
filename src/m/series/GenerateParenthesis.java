package m.series;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @Author luckylau
 * @Date 2022/3/6
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, 0, 0, n, "");
        return result;
    }

    private void backtracking(List<String> result, int left, int right, int n, String str) {
        if (right > left) {
            return;
        }
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n) {
            backtracking(result, left + 1, right, n, str + "(");
        }
        if (right < left) {
            backtracking(result, left, right + 1, n, str + ")");
        }
    }
}
