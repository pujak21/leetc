public class Binarysubarray {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarraysAtMost(nums, goal) - countSubarraysAtMost(nums, goal - 1);
    }

    private int countSubarraysAtMost(int[] nums, int goal) {

        if (goal < 0) return 0; // If goal becomes negative, no subarray can match

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // shrink window if sum is more than allowed
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            // count all valid subarrays ending at right pointer
            count += (right - left + 1);
        }

        return count;
    }

    // Main function to test the code
    public static void main(String[] args) {
        Binarysubarray obj = new Binarysubarray();

        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        int result = obj.numSubarraysWithSum(nums, goal);

        System.out.println("Number of subarrays with sum = " + goal + " is: " + result);
    }
}

