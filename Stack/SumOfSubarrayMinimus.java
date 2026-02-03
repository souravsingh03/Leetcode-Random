package Stack;
import java.util.Stack;

class Solution {

    /**
     * Finds the index of the Nearest Smaller element to the Left (NSL)
     * for each element in the array.
     *
     * If no smaller element exists on the left, index is -1.
     */
    private static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return nsl;
    }

    /**
     * Finds the index of the Nearest Smaller element to the Right (NSR)
     * for each element in the array.
     *
     * If no smaller element exists on the right, index is n.
     */
    private static int[] nearestSmallerToRight(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nsr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nsr;
    }

    /**
     * Computes the sum of minimums of all subarrays.
     */
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;

        int[] nsl = nearestSmallerToLeft(arr);
        int[] nsr = nearestSmallerToRight(arr);

        long result = 0;

        for (int i = 0; i < n; i++) {
            long leftCount = i - nsl[i];
            long rightCount = nsr[i] - i;
            result = (result + arr[i] * leftCount * rightCount) % mod;
        }

        return (int) result;
    }
}
