class Solution {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if(map.get(nums[i]) > 1) return true;;
        }
        return false;
    }
}