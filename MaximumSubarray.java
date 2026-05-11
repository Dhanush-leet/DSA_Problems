public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();
        System.out.println("Test 1: " + sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("Test 2: " + sol.maxSubArray(new int[]{1}));
        System.out.println("Test 3: " + sol.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
