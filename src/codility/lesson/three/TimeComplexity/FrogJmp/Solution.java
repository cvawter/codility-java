package codility.lesson.three.TimeComplexity.FrogJmp;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {10, 85, 30},
            {1, 1, 1},
            {1, 1, 1000000000},
            {1, 1000000000, 1},
            {1, 1000000000, 2},
            {1, 1000000000, 3},
            {1, 1000000000, 4},
            {1, 1000000000, 5},
            {1, 1000000000, 6},
            {1, 1000000000, 7},
            {1, 1000000000, 8},
            {1, 1000000000, 9},
            {1, 1000000000, 10},
            {1, 1000000000, 100},
            {1, 1000000000, 10000},
            {1, 1000000000, 1},
            {1, 1000000000, 1000000000},
            {1, 1000000000, 999999999},
            {1, 1000000000, 999999999},
            {1, 1000000000, 1},
            {1, 1000000000, 2},
            {1, 1000000000, 3},
            {1, 1000000000, 4},
            {1, 1000000000, 5},
            {1, 1000000000, 6},
            {1, 1000000000, 7},
            {1, 1000000000, 8},
            {1, 1000000000, 9},
            {1, 1000000000, 10},
            {1, 1000000000, 100},
            {1, 1000000000, 1000},
            {1, 1000000000, 10000},
            {1, 1000000000, 100000},
            {1, 1000000000, 1000000}
        };
        for (int[] testCase : testCases) {
            System.out.println("Test case: " + testCase[0] + ", " + testCase[1] + ", " + testCase[2]);
            System.out.println("Minimum number of jumps: " + solution.solution(testCase[0], testCase[1], testCase[2]));
        }

    }

    /**
     * This method calculates the minimum number of jumps needed for a frog to reach its target.
     * 
     * The frog starts at position X and wants to reach or cross position Y. It can jump a fixed distance D
     * in each jump. The method returns the minimum number of jumps required.
     * 
     * @param X the starting position of the frog
     * @param Y the target position
     * @param D the distance covered in each jump
     * @return the minimum number of jumps required
     */
    public int solution(int X, int Y, int D) {

        // Calculate the distance to cover
        int distanceToCover = Y - X;
        // Calculate the number of jumps needed
        int jumpsNeeded = distanceToCover / D;
        // If there is a remainder, we need one more jump
        if (distanceToCover % D != 0) {
            jumpsNeeded++;
        }
        return jumpsNeeded;
    }
}
