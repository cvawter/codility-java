package main.codility.lesson.three.TimeComplexity.PermMissingElem;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {2, 3, 1, 5},
            {},
            {1},
            {1, 2},
            {1, 2, 3},
            {1, 2, 4},
            {1, 3, 4},
            {2, 3, 4}, 
            {1, 2, 3, 4},
            {1, 2, 3, 5},
            IntStream.range(1, 1000).toArray(), // {1, 2, 3, ..., 999}
            IntStream.range(1, 100000).toArray(), // {1, 2, 3, ..., 99999}
            IntStream.range(1, 191068).toArray(), // {1, 2, 3, ..., 191067}
            IntStream.range(1, 191069).toArray(), // {1, 2, 3, ..., 191068}
            IntStream.range(1, 1000000).toArray() // {1, 2, 3, ..., 999999}
        };
        for (int[] testCase : testCases) {
            // System.out.println("Test case: " + java.util.Arrays.toString(testCase));
            System.out.println("Missing element: " + solution.solution(testCase));
        }
    }

    /**
     * This method finds the missing element in a sequence of integers from 1 to N+1.
     * 
     * The input array A contains N integers, which are all distinct and within the range [1, N+1].
     * The method returns the missing integer in the sequence.
     * 
     * @param A the input array containing N distinct integers
     * @return the missing integer in the sequence
     */
    public int solution(int[] A) {

        int n = A.length;
        long missingElement = -1;

        if (A == null || A.length == 0) { return 1; } // If the array is null or empty, the missing element is 1
        else if (A.length == 1) { return A[0] == 1 ? 2 : 1; } // If the array has one element, return the next number or 1 if it's not present
        else {
            long expectedSum = (n + 1) * (n + 2) / 2; // Sum of first n+1 natural numbers (if the array was complete)
            long actualSum = java.util.Arrays.stream(A).sum(); // Sum of elements in the array
            missingElement = expectedSum - actualSum; // The missing element is the difference between expected and actual sum
        }
        return missingElement > Integer.MAX_VALUE ? -1 : (int) missingElement; // If the missing element exceeds Integer.MAX_VALUE, return -1
    }
}
