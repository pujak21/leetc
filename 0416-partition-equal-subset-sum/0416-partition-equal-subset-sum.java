class Solution {

    static boolean solveMem(int index, int[] nums, int n, int target, int[][] dp){
        //base cases
        if(target == 0) 
            return true;
        if(index >= n || target < 0)
            return false;
        //memo check
        if(dp[index][target] != -1){
            return dp[index][target] == 1;
        }

        boolean include = solveMem(index+1, nums, n, target-nums[index], dp);
        boolean exclude = solveMem(index+1, nums, n, target, dp);

        dp[index][target] = (include || exclude) ? 1:0;
        return include || exclude;
                 
           
    }


    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int i = 0; i<n; i++){
            total += nums[i];
        }

        //odd sum -> cannot partition
        if((total & 1) == 1) return false;

        int target = total/2;

        int[][] dp = new int[n][target + 1];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=target; j++){
                dp[i][j] = -1;
            }
        }

        return solveMem(0, nums, n, target, dp);
    }
}