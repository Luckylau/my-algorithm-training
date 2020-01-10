package o.series;
/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

import java.util.Stack;

/**
 * @Author luckylau
 * @Date 2019/12/24
 */
public class IsPopOrder {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        IsPopOrder isPopOrder = new IsPopOrder();
        System.out.println(isPopOrder.isPopOrder(pushA, popA));
    }

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length == 0) {
            return false;
        }
        if (popA == null || popA.length == 0) {
            return false;
        }
        int popAIndex = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while (!s.isEmpty() && s.peek() == popA[popAIndex]) {
                s.pop();
                popAIndex++;
            }
        }
        return s.isEmpty();

    }

}
