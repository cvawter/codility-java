package main.codility.lesson.four.CountingElements.MissingInteger;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 3, 6, 4, 1, 2}, // Test case from problem statement
            {1, 2, 3},          // Test case from problem statement
            {-1, -3},           // Test case from problem statement 
            {1, 2, 3, 4, 5},    // No missing integers
            {-1, -2, -3},       // Negative integers
            {0, 0, 0},          // All zeros
            {1, 2, 3, 4, 6}     // Missing integer is 5
        };
        for (int[] testCase : testCases) {
            System.out.println("Test case: " + Arrays.toString(testCase));
            System.out.println("Missing integer: " + solution.solution(testCase));
        }
    }

    /**
     * Finds the smallest positive integer that does not occur in the array A.
     *
     * The algorithm works by creating a boolean array to track which positive integers are present in the
     * input array A. It then iterates through this boolean array to find the first missing positive integer.
     * 
     * If the array is empty or null, it returns -1.
     *  
     * The time complexity of this solution is O(N), where N is the length of the input array A.
     * The space complexity is O(N) due to the boolean array used to track the presence of integers.
     *
     * @param A An array of integers
     * @return The smallest positive integer that does not occur in the array A.
     */
    public int solution(int[] A) {
        
        if (A.length == 0 || A == null) {
            return -1;
        }

        int missingInteger = 1;
        boolean[] visited = new boolean[A.length];

        for (int I : A) {
            if (I > 0 && I <= A.length) {
                visited[I-1] = true;
            }
        }

        for (int i=0; i < visited.length; i++) {
            if (!visited[i]) {
                missingInteger = i+1;
                break;
            } else {
                missingInteger = i+2;
            }
        }

        return missingInteger;
    }
}
