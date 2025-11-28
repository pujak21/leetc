public class Binarysubarray {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarraysAtMost(nums, goal) - countSubarraysAtMost(nums, goal - 1);
    }

    private int countSubarraysAtMost(int[] nums, int goal) {

        if (goal < 0) return 0; 

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

           
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            
            count += (right - left + 1);
        }

        return count;
    }

   
    public static void main(String[] args) {
        Binarysubarray obj = new Binarysubarray();

        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        int result = obj.numSubarraysWithSum(nums, goal);

        System.out.println("Number of subarrays with sum = " + goal + " is: " + result);
    }
}

