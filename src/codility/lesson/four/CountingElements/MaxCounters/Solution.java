package codility.lesson.four.CountingElements.MaxCounters;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test cases for the MaxCounters problem
        TestCase[] testCases = {
            new TestCase(5, new int[]{3, 4, 4, 6, 1, 4, 4}), // Example from the problem statement
            new TestCase(5, new int[]{1, 2, 3, 4, 5}),       // Incrementing all counters
            new TestCase(5, new int[]{1, 1, 1, 1}),          // Incrementing the first counter multiple times
            new TestCase(5, new int[]{2, 2, 2}),             // Incrementing the second counter multiple times
            new TestCase(5, new int[]{5, 5, 5}),             // Max operation without any increments
            new TestCase(0, new int[]{}),                    // No counters and empty operations array
            new TestCase(0, null),                // No counters and no (null) operations array
            new TestCase(5, new int[]{6, 7, 8, 9, 10}),      // All operations are greater than N
            new TestCase(5, new int[]{6, 7, 8, 9, 10, 5, 6}) // One counter increment and a max counter after ignored several ignore operations
        };
        for (TestCase testCase : testCases) {
            System.out.println("Test case with " + testCase.numCounters + " counters and operations: " + Arrays.toString(testCase.operations));
            int[] counters = solution.solution(testCase.numCounters, testCase.operations);
            System.out.println("Final counters: " + java.util.Arrays.toString(counters));
            System.out.println("---------------------------------------------------------------");
        }
    }

    /**
     * This method calculates the final values of counters after applying a series of operations.
     * Each operation is either incrementing a specific counter or setting all counters to the maximum value.
     * The algorithm processes the operations in O(N + M) time complexity, where N is the number of counters and M is the number of operations.
     * 
     * @param N The number of counters.
     * @param A An array of operations, where each element is either an increment operation (1 to N) or a max operation (N + 1).
     */
    public int[] solution(int N, int[] A) {

        if (N <= 0 || A == null || A.length == 0) {
            return new int[0]; // Return an empty array if N is invalid or A is empty
        }
            
        int[] counters = new int[N];
        int maxCounter = 0; // To track the maximum value of counters

        for (int operation : A) {
            if (operation >= 1 && operation <= N) {
                counters[operation-1]++;
                if (maxCounter < counters[operation-1]) {
                    maxCounter++;
                }
            } else { 
                if (operation == N+1) {
                    Arrays.fill(counters, maxCounter);
                }
            }
            System.out.println(Arrays.toString(counters));
        }
        return counters;
    }

    /**
     * This is a Copilot-generated Codility solution for the MaxCounters problem.
     * 
     * This method calculates the final values of counters after applying a series of operations.
     * Each operation is either incrementing a specific counter or setting all counters to the maximum value.
     * The algorithm processes the operations in O(N + M) time complexity, where N is the number of counters and M is the number of operations.
     * 
     * The method handles edge cases such as invalid N or empty operations array.
     * 
     * The method ensures that counters are only updated to the last maximum value before incrementing,
     * preventing unnecessary increments when a max operation is applied.
     * This implementation avoids unnecessary operations by keeping track of the last maximum value
     * and applying it only when necessary, ensuring efficient updates to the counters.
     * 
     * @param N The number of counters.
     * @param A An array of operations, where each element is either an increment operation (1 to N) or a max operation (N + 1).
     * @return An array of integers representing the final values of the counters after all operations have been applied.
     */
    public int[] solution_copilot(int N, int[] A) {

        if (N <= 0 || A == null || A.length == 0) {
            return new int[0]; // Return an empty array if N is invalid or A is empty
        }
            
        int[] counters = new int[N];
        int maxCounter = 0; // To track the maximum value of counters
        int lastMax = 0; // To track the last max operation value

        for (int operation : A) {
            if (operation >= 1 && operation <= N) {
                if (counters[operation - 1] < lastMax) {
                    counters[operation - 1] = lastMax; // Set to last max before incrementing
                }
                counters[operation - 1]++;
                if (maxCounter < counters[operation - 1]) {
                    maxCounter = counters[operation - 1];
                }
            } else if (operation == N + 1) {
                lastMax = maxCounter; // Update last max to current max
            }
        }

        // Apply the last max operation to all counters
        for (int i = 0; i < N; i++) {
            if (counters[i] < lastMax) {
                counters[i] = lastMax;
            }
        }
        return counters;        
    }

    static class TestCase {
        int numCounters;
        int[] operations;

        public TestCase(int N, int[] operations) {
            this.numCounters = N;
            this.operations = operations;
        }
    }
}
