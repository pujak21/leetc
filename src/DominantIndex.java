import java.util.*;

class DominantIndex {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        // Step 1: Find maximum element and its index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        // Step 2: Check if max is at least twice of all others
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && max < 2 * nums[i]) {
                return -1;
            }
        }

        return maxIndex;
    }

    // main method for testing
    public static void main(String[] args) {
        DominantIndex sol = new DominantIndex();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(sol.dominantIndex(nums1)); // Output: -1

        int[] nums2 = {3, 6, 1, 0};
        System.out.println(sol.dominantIndex(nums2)); // Output: 1

        int[] nums3 = {1};
        System.out.println(sol.dominantIndex(nums3)); // Output: 0
    }
}

