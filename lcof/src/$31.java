/**
 * 栈的压入弹出序列
 * 1.创建新栈
 * 2.pushed序列不断压入栈中
 * 3.当栈顶元素与popped序列相同，弹出，循环
 * 4.结果栈空，则返回true
 */
import java.util.Stack;

public class $31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    //剑指offer版 有误
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        if (pushed.length == 1 && pushed[0] == popped[0]) {
            return true;
        }

        int i = 0;
        int j = 0;
        boolean isPossible = false;
        Stack<Integer> stack = new Stack<>();

        while (i < popped.length) {
            while (stack.isEmpty() || stack.peek() != popped[j]) {
                if (j == popped.length-1) {
                    break;
                }
                stack.push(pushed[i++]);

                if (stack.peek() != popped[j]) {
                    break;
                }

                stack.pop();
                j++;
            }

            if (stack.isEmpty() && j == popped.length-1) {
                isPossible = true;
            }
        }
        return isPossible;
    }
}
