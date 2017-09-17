package demo;

import java.util.Stack;

public class ReverseStack {
	public void reverseStack(Stack<Object> stack) {
		if (stack.isEmpty() || stack == null) {
			return;
		}
		Object object = stack.pop();
		reverseStack(stack);
		putToBottom(stack, object);
	}

	private void putToBottom(Stack<Object> stack, Object object) {
		if (stack.isEmpty()) {
			stack.push(object);
			return;
		}
		Object obj = stack.pop();
		putToBottom(stack, object);
		stack.push(obj);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Object> stack = new Stack<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		ReverseStack reverseStack = new ReverseStack();
		reverseStack.reverseStack(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
