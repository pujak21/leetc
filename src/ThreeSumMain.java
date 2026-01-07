

import java.util.*;

public class ThreeSumMain {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        if (n < 3) return result;

        Arrays.sort(nums);   // Step 1: sort

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate fixed element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;    // need bigger sum
                } else {
                    right--;   // need smaller sum
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ans = threeSum(nums);

        System.out.println(ans);
    }
}

