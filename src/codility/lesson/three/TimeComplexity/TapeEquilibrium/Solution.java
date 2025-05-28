package codility.lesson.three.TimeComplexity.TapeEquilibrium;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {3, 1, 2, 4, 3},
            {-1000, -500, 0, 500, 1000},
            {1, 2, 3, 4, 5},
            {10, -10, 20, -20},
            {0, 0, 0, 0, 0},
            {100, -100, 200, -200},
            {1, 1, 1, 1, 1},
            {5, 5, 5, 5, 5},
            {-1, -2, -3, -4, -5},
            {10, 20, 30, 40}
        };
        for (int[] testCase : testCases) {
            System.out.println("Test case: " + java.util.Arrays.toString(testCase));
            System.out.println("Minimum difference: " + solution.solution(testCase));
        }
    }

    // This method calculates the minimum difference between the sums of two parts of an array.
    // Consider an O(n) solution with a single pass.
    // This algorithm is O(n^2) due to the nested loops (see the stream sums). 
    public int solution(int[] A) {
        long minDifference = 0;
        if (A == null || A.length < 2) {
            return Math.toIntExact(minDifference); // Not enough elements to form a partition
        }
        for (int i = 1; i < A.length; i++) {
            long leftSum = java.util.Arrays.stream(A, 0, i).sum();
            long rightSum = java.util.Arrays.stream(A, i, A.length).sum();
            long difference = Math.abs(leftSum - rightSum);
            System.out.println("Left sum: " + leftSum + ", Right sum: " + rightSum + ", Difference: " + difference);
            if (i == 1) {
                minDifference = difference; // Initialize minDifference with the first calculated difference
            }
            if (difference < minDifference) {
                minDifference = difference;
            }
        }   
        return Math.toIntExact(minDifference);
    }
}
