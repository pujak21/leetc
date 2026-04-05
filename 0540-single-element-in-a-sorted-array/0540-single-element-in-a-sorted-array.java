class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = low;

        while(low<=high){
            mid = low + (high-low)/2;

            if(mid == 0 || mid == n-1) return nums[mid];

            if(nums[mid] == nums[mid-1]){
                if(mid%2 == 0){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid] == nums[mid+1]){
                if(mid%2 != 0){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                return nums[mid];
            }
        }
        return nums[low];
    }
}