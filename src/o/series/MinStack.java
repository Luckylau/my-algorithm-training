package o.series;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Objects;
import java.util.Stack;

/**
 * @Author luckylau
 * @Date 2019/12/21
 */
public class MinStack {
    Stack<Integer> normalStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        normalStack.push(node);
        if (minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        }
    }

    public void pop() {
        int value = normalStack.pop();
        if (Objects.equals(value, minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return normalStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
