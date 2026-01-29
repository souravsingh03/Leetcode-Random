package Stack;

import java.util.Stack;

/*
 * LeetCode 224: Basic Calculator
 * Difficulty: Hard
 *
 * Approach:
 * - Use stack to store previous result and sign when encountering '('
 * - Evaluate expression in a single pass
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class BasicCalculator {

    public int calculate(String s) {
        int n = s.length();
        int num = 0;
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }

            else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }

            else if (c == '(') {
                // Save current state
                stack.push(result);
                stack.push(sign);

                // Reset for
                result = 0;
                sign = 1;
                num = 0;
            }

            else if (c == ')') {
                result += sign * num;
                num = 0;

                int prevSign = stack.pop();
                int prevResult = stack.pop();

                result = prevResult + prevSign * result;
            }
        }

        result += sign * num;
        return result;
    }
}
