package Stack;
import java.util.Stack;

class Solution {

    /**
     * Removes k digits from the given number string to make it the smallest possible.
     *
     * @param num the numeric string
     * @param k   number of digits to remove
     * @return the smallest possible number as a string
     */
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        // Traverse digits from left to right
        for (char digit : num.toCharArray()) {

            // Remove larger previous digits if current digit is smaller
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If removals are still left, remove from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char digit : stack) {
            result.append(digit);
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}