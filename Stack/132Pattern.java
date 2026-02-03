package Stack;
import java.util.Stack;

/**
 * LeetCode 456 - 132 Pattern
 *
 * The idea is to traverse the array from right to left while maintaining:
 * 1. A stack that keeps possible candidates for the '3' element in decreasing order.
 * 2. A variable `third` (num3) that represents the best possible '2' element found so far.
 *
 * If at any point nums[i] < third, a 132 pattern exists.
 */
class Solution {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        // Stack to store possible candidates for '3'
        Stack<Integer> stack = new Stack<>();

        // This represents the '2' in the 132 pattern
        int third = Integer.MIN_VALUE;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // If current element is smaller than 'third',
            // we have found a valid 132 pattern
            if (nums[i] < third) {
                return true;
            }

            // Pop elements smaller than nums[i] and update 'third'
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                third = stack.pop();
            }

            // Push current element as a candidate for '3'
            stack.push(nums[i]);
        }

        return false;
    }
}