class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //int jump  = 0;
        int reach = 0;
        for(int i = 0; i<=reach && i<n; i++){
            reach = Math.max(reach, i+nums[i]);
            if(reach >= n-1) return true;
        }

        return false;
    }
}


        /*if(n==1) return true;

        for(int i = 0; i<n-1; i++){
            
            for(int j = i+1; j <= i+ nums[i] && j<n; j++){
                //int jump = i+j;
                if(j == n-1) return true;

            }
        }*/