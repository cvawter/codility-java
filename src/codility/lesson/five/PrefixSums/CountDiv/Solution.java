package codility.lesson.five.PrefixSums.CountDiv;

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases for the CountDiv problem
        int[][] testCases = {
            {6, 11, 2},   // Example from the problem statement
            {0, 0, 1},    // Dividing by 1
            {1, 10, 1},   // Dividing by 1
            {5, 5, 5},    // Dividing by itself
            {10, 20, 3},  // Dividing by a number greater than the range
            {-10, -5, 2}, // Negative range with positive divisor
            {10, 10, 0},  // A==B with an invalid divisor
            {10, 10, 1},  // A==B with and A and B are divisible by the divisor
            {10, 10, 3}   // A==B with and A and B are not divisible by the divisor
        };
        
        for (int[] testCase : testCases) {
            System.out.println("Test case: " + java.util.Arrays.toString(testCase));
            System.out.println("CountDiv result: " + solution.solution(testCase[0], testCase[1], testCase[2]));
        }
    }

    /**
     * This method calculates the number of integers in the range [A, B] that are divisible by K.
     * 
     * @param A the lower bound of the range, inclusive
     * @param B the upper bound of range, inclusive
     * @param K the divisor
     * 
     * If K is zero or negative, or A is greater than B, it returns 0.
     * If A is less than 0 or B is less than 0, it also returns 0 as the range is invalid.
     *  
     * @return the count of integers in the range [A, B] that are divisible by K.
     */
    public int solution(int A, int B, int K) {
        
        int count = 0; // number of values in [A, B] that are divisible by K

        if (K <= 0 || A > B || A < 0 || B < 0) { // invalid parameter values
            return 0;
        }

        // Calculate the number of integers divisible by K in the range [A, B]
        for (int i=A; i<=B; i++) {
            if (i%K==0) {
                count++;
            }
        }
        
        return count;
    }

    /**
     * Copilot solution for the CountDiv problem.
     * 
     * This method calculates the number of integers in the range [A, B] that are divisible by K.
     * It uses a mathematical approach to find the count without iterating through the range.
     * The formula used is:
     *   count = (B / K) - ((A - 1) / K)
     * This formula counts how many multiples of K are there from 0 to B and subtracts how many multiples of K are there from 0 to A-1.
     * This approach is more efficient than iterating through the range, especially for large values of A and B.
     * 
     * @param A the lower bound of the range, inclusive
     * @param B the upper bound of range, inclusive
     * @param K the divisor
     * @return the count of integers in the range [A, B] that are divisible by K.
     */
    public int copilot(int A, int B, int K) {
        if (K <= 0 || A > B) {
            return 0; // Invalid parameters
        }

        // Calculate the number of integers divisible by K in the range [A, B]
        int countB = B / K; // Count of numbers divisible by K from 0 to B
        int countA = (A - 1) / K; // Count of numbers divisible by K from 0 to A-1

        return countB - countA; // The difference gives the count in [A, B]
    }
}
