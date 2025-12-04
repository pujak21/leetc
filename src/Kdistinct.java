import java.util.*;

public class Kdistinct {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        Solution3 sol = new Solution3();
        int result = sol.subarraysWithKDistinct(nums, k);

        System.out.println("Output: " + result);  // Expected: 7
    }
}

class Solution3 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return kDistinct(nums, k) - kDistinct(nums, k - 1);
    }

    private int kDistinct(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // Important fix: shrink window until it becomes valid
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            cnt += (r - l + 1);
            r++;
        }

        return cnt;
    }
}
