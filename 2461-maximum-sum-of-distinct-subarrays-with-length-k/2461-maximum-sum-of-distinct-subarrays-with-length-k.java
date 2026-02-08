class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        long sum = 0, maxSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;

        while(r<n){
                sum += nums[r];
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
          
            while(map.get(nums[r]) > 1){
                map.put(nums[l], map.get(nums[l]) - 1);
                sum -= nums[l];
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                 l++;
            }
            if (r - l + 1 > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                sum -= nums[l];
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }

            r++; 
        }

        return maxSum;
    }
}