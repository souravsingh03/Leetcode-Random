package Stack;
import java.util.Stack;

class Solution {

    /**
     * LeetCode 1963 - Minimum Number of Swaps to Make the String Balanced
     *
     * Idea:
     * - Use a stack to cancel valid "[]" pairs.
     * - Push '[' onto the stack.
     * - When ']' is found, pop one '[' if available.
     * - After processing the string, the stack size represents
     *   unmatched '[' brackets.
     *
     * Each swap can fix two unmatched brackets.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            } else { // ch == ']'
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        // Minimum swaps required
        return (stack.size() + 1) / 2;
    }
}