package codility.lesson.two.Arrays.OddOccurrencesInArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {   
        
        int[][] testCases = {
            {9, 3, 9, 3, 9, 7, 9},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 3},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            {100}
        };

        for (int[] testCase : testCases) {
            Solution solution = new Solution();
            int result = solution.solution(testCase);
            System.out.println("Unpaired element: " + result);
        }
    }

    public int solution(int[] A) {
        
        int unpairedElement = -1;
        HashMap<Integer, Integer> counts = new HashMap<>();

        // Count occurrences of each element
        for (int element : A) {
            counts.put(element, counts.getOrDefault(element, 0) + 1);
        }

        // Get the entry set
        Set<Map.Entry<Integer, Integer>> entrySet = counts.entrySet();
        
        // Find the unpaired element
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() % 2 != 0) {
                unpairedElement = entry.getKey();
                break;
            }
        }
        
        // If no unpaired element is found, return -1
        if (unpairedElement == -1) {
            System.out.println("No unpaired element found.");
            return -1;
        }
        
        return unpairedElement;
    }
}
