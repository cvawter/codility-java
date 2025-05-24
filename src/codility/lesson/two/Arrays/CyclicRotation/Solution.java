package codility.lesson.two.CyclicRotation;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCase[] testCases = {
            new TestCase(0, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(1, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(2, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(3, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(4, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(5, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(6, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(7, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(8, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(9, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(10, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(11, new int[]{3, 8, 9, 7, 6}), // Example case
            new TestCase(0, new int[]{0, 0, 0}), // Example case
            new TestCase(1, new int[]{0, 0, 0}), // Example case 
            new TestCase(2, new int[]{0, 0, 0}), // Example case
            new TestCase(3, new int[]{0, 0, 0}), // Example case
            new TestCase(4, new int[]{0, 0, 0}), // Example case
            new TestCase(0, new int[]{1, 2, 3, 4}), // Example case
            new TestCase(1, new int[]{1, 2, 3, 4}), // Example case
            new TestCase(2, new int[]{1, 2, 3, 4}), // Example case
            new TestCase(3, new int[]{1, 2, 3, 4}), // Example case
            new TestCase(4, new int[]{1, 2, 3, 4}), // Example case
            new TestCase(5, new int[]{1, 2, 3, 4}), // Example case
            new TestCase(0, new int[]{-1000, -500, 0, 500, 1000}), // Example case
            new TestCase(1, new int[]{-1000, -500, 0, 500, 1000}), // Example case
            new TestCase(2, new int[]{-1000, -500, 0, 500, 1000}), // Example case
            new TestCase(3, new int[]{-1000, -500, 0, 500, 1000}), // Example case
            new TestCase(4, new int[]{-1000, -500, 0, 500, 1000}), // Example case
            new TestCase(5, new int[]{-1000, -500, 0, 500, 1000}), // Example case
            new TestCase(6, new int[]{-1000, -500, 0, 500, 1000}), // Example case
            new TestCase(7, new int[]{-1000, -500, 0, 500, 1000}), // Example case
        };
        for (TestCase testCase : testCases) {
            int [] rotatedArray = solution.solution(testCase.inputArray, testCase.rotations);
            for (int number : rotatedArray) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public int[] solution(int[] A, int K) {
        if (A.length == 0 || A.length == K || K == 0) {
            return A;
        }
        int[] rotatedArray = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            rotatedArray[(i + K) % A.length] = A[i];
        }
        return rotatedArray;
    }
    
    static class TestCase {
        int rotations;
        int[] inputArray;

        public TestCase(int R, int[] A) {
            this.rotations = R;
            this.inputArray = A;
        }
    }
}
