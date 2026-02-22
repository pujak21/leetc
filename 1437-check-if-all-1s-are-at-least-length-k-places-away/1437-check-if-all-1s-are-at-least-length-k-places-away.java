class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 1, len = 0;

        while(r<n){
            if(nums[l] != 1) l++;
            else if(nums[r] == 1){
                len = r-l - 1;
                l = r;
                if(len < k) return false;
            }
            r++;
        }
        return true;
    }
}