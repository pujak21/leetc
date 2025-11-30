
public class Nicesubarray {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums = {1,1,2,1,1};
        int k = 3;

        int result = solution.numberOfSubarrays(nums, k);
        System.out.println("Number of nice subarrays: " + result);
    }
}

class Solution2 {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSub(nums, k) - countSub(nums, k-1);
    }

    private int countSub(int[] nums, int k){
        if(k < 0) return 0;

        int l = 0, sum = 0, count = 0;

        for(int r = 0; r < nums.length; r++){
            // if number is odd add 1 otherwise add 0
            sum += (nums[r] % 2 != 0) ? 1 : 0;

            while(sum > k){
                // remove left side odd count if any
                sum -= (nums[l] % 2 != 0) ? 1 : 0;
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }
}

