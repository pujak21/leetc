import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        // Convert int[] to Integer[] for custom sorting
        Integer[] nums = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        
        Arrays.sort(nums, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            // First sort by bit count
            if(countA != countB) {
                return countA - countB;
            }
            
            // If same bit count, sort normally
            return a - b;
        });
        
        // Convert back to int[]
        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        
        return arr;
    }
}