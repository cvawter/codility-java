package main.codility.lesson.one.Iterations.BinaryGap;

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1, 2, 147, 483, 647};
        for (int number : numbers) {
            System.out.println(
                "N: " + number +
                "\nBinary: " + Integer.toBinaryString(number) +
                "\nLongest Binary Gap: " + solution.solution(number)
            );
        }
    }

    /**
     * This method calculates the largest binary gap of a given integer N.
     * 
     * A binary gap is defined as a sequence of consecutive zeros that is surrounded
     * by ones at both ends in the binary representation of N.
     * 
     * Note: If N is 0 (all zeros), there is no binary gap. 
     * Note: If N is -1 (represented in 2's complement by all ones), there is no binary gap.
     * 
     * Check for N = 0, -1 to avoid unnecessary calculations, or limit the range of N.
     *
     * @param N the integer to calculate the binary gap for
     * @return the length of the longest binary gap
     */
    public int solution(int N) {
        
        int longestGapLength = 0;
        String binaryString = Integer.toBinaryString(N);
        int gapLength = 0;
            
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (gapLength > longestGapLength) {
                    longestGapLength = gapLength;
                }
                gapLength = 0;
            } else {
                if (binaryString.substring(0, i).contains("1")) { // Only count zeros after the first '1'
                    gapLength++;
                }
            }
        }
        
        return longestGapLength;
    } 
}
