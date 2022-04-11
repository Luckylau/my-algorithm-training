package m.series;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @Author luckylau
 * @Date 2022/4/11
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch.equals('(') || ch.equals('{') || ch.equals('[')) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character cha = stack.pop();
                if (cha.equals('(') && !ch.equals(')')) {
                    return false;
                }
                if (cha.equals('{') && !ch.equals('}')) {
                    return false;
                }
                if (cha.equals('[') && !ch.equals(']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
