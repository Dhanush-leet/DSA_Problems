// LeetCode #53 - Maximum Subarray
// NeetCode: Arrays & Hashing
// Difficulty: Medium
//
// Problem:
// Given an integer array nums, find the subarray with the largest sum
// and return its sum.
//
// Example:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6 (subarray [4,-1,2,1])
//
// Approach: Kadane's Algorithm - O(n) Time | O(1) Space

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend current subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();

        System.out.println("Test 1: " + sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println("Test 2: " + sol.maxSubArray(new int[]{1}));                      // 1
        System.out.println("Test 3: " + sol.maxSubArray(new int[]{5,4,-1,7,8}));             // 23
    }
}
