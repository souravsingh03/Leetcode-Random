package Stack;
import java.util.*;

/**
 * LeetCode: Parse Boolean Expression
 *
 * Supported operators:
 *  - '!' : NOT
 *  - '&' : AND
 *  - '|' : OR
 *
 * Approach:
 *  - Use a stack to process the expression character by character.
 *  - When a closing parenthesis ')' is found, evaluate the sub-expression.
 *  - Push the result ('t' or 'f') back onto the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {

    /**
     * Evaluates a boolean operation on a list of operands.
     */
    private static char evaluate(List<Character> operands, char operator) {
        int trueCount = 0;
        int falseCount = 0;

        for (char ch : operands) {
            if (ch == 't') {
                trueCount++;
            } else {
                falseCount++;
            }
        }

        if (operator == '|') {
            return trueCount > 0 ? 't' : 'f';
        }

        if (operator == '&') {
            return trueCount == operands.size() ? 't' : 'f';
        }

        // operator == '!'
        return operands.get(0) == 't' ? 'f' : 't';
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') {
                continue;
            }

            if (ch == ')') {
                List<Character> operands = new ArrayList<>();

                // Collect operands
                while (stack.peek() != '(') {
                    operands.add(stack.pop());
                }

                stack.pop(); // Remove '('
                char operator = stack.pop();

                // Evaluate and push result
                stack.push(evaluate(operands, operator));
            } else {
                stack.push(ch);
            }
        }

        return stack.peek() == 't';
    }
}