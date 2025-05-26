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

    public int solution(int[] A) {
        long totalSum = 0;
        for (int value : A) {
            totalSum += value;
        }

        long leftSum = 0;
        long minDifference = Long.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            long rightSum = totalSum - leftSum;
            long difference = Math.abs(leftSum - rightSum);
            if (difference < minDifference) {
                minDifference = difference;
            }
        }

        return (int) minDifference;
    }

    // public int solution(int[] A) {
    //     long minDifference = 0;
    //     if (A == null || A.length < 2) {
    //         return Math.toIntExact(minDifference); // Not enough elements to form a partition
    //     }
    //     for (int i = 1; i < A.length; i++) {
    //         long leftSum = java.util.Arrays.stream(A, 0, i).sum();
    //         long rightSum = java.util.Arrays.stream(A, i, A.length).sum();
    //         long difference = Math.abs(leftSum - rightSum);
    //         System.out.println("Left sum: " + leftSum + ", Right sum: " + rightSum + ", Difference: " + difference);
    //         if (i == 1) {
    //             minDifference = difference; // Initialize minDifference with the first calculated difference
    //         }
    //         if (difference < minDifference) {
    //             minDifference = difference;
    //         }
    //     }   
    //     return Math.toIntExact(minDifference);
    // }
}
