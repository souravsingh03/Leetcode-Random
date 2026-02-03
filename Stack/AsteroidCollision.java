package Stack;
import java.util.Stack;

class Solution {

    /**
     * Simulates asteroid collisions using a stack.
     *
     * @param asteroids array representing asteroids with direction and size
     * @return remaining asteroids after all collisions
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            // Handle collisions: only when stack top moves right and current moves left
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int collisionResult = asteroid + stack.peek();

                if (collisionResult < 0) {
                    // Stack asteroid is smaller → it explodes
                    stack.pop();
                } 
                else if (collisionResult > 0) {
                    // Current asteroid is smaller → it explodes
                    asteroid = 0;
                } 
                else {
                    // Both asteroids are equal → both explode
                    asteroid = 0;
                    stack.pop();
                }
            }

            // Push asteroid if it survived all collisions
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        int index = 0;
        for (int val : stack) {
            result[index++] = val;
        }

        return result;
    }
}