package m.series;

import java.util.Stack;

/**
 * 155.最小栈
 *
 * @Author luckylau
 * @Date 2021/4/15
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (!minStack.isEmpty() && val <= minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
