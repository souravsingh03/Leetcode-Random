package Stack;
import java.util.*;

/**
 * LeetCode 2197 - Replace Non-Coprime Numbers in Array
 *
 * Approach:
 * - Use a stack to process numbers from left to right.
 * - For each number, keep merging with the stack top while they are non-coprime.
 * - Replace non-coprime pairs with their LCM.
 */
class Solution {

    /**
     * Computes GCD using Euclidean Algorithm.
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    /**
     * Replaces consecutive non-coprime numbers with their LCM.
     *
     * @param nums input array
     * @return list after replacing non-coprime numbers
     */
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            stack.push(num);

            // Merge while the top two elements are non-coprime
            while (stack.size() >= 2) {
                int b = stack.pop(); // top
                int a = stack.pop(); // below top

                int g = gcd(a, b);

                if (g == 1) {
                    // Coprime: restore order and stop merging
                    stack.push(a);
                    stack.push(b);
                    break;
                } else {
                    // Non-coprime: merge into LCM and continue
                    int lcm = (a / g) * b;
                    stack.push(lcm);
                }
            }
        }

        return new ArrayList<>(stack);
    }
}