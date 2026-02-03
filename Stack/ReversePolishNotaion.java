package Stack;
import java.util.Stack;

/**
 * LeetCode 150: Evaluate Reverse Polish Notation
 *
 * Approach:
 * - Use a stack to store operands.
 * - When an operator is encountered, pop the top two elements.
 * - Apply the operator in correct order (important for '-' and '/').
 * - Push the result back onto the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } 
            else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } 
            else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } 
            else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b); // integer division truncates toward zero
            } 
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
