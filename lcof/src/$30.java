/**
 * 最小栈的实现
 * 设两个栈，一个存放数据，一个放当前栈的最小值
 * push：数据栈正常存放，
 *       最小栈：当栈非空，存放栈顶元素与新元素的最小值；当栈空，存放新元素
 * pop：同时弹出元素
 * min：最小栈弹出元素
 * top：数据栈弹出元素
 */

import java.util.Stack;

public class $30 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    // public MinStack() {
    //     stack = new Stack<>();
    //     minStack = new Stack<>();
    // }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            minStack.push(Math.min(minStack.peek(), x));
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return minStack.peek();
    }
}
