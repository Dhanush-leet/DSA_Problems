// LeetCode #1 - Two Sum
// NeetCode: Arrays & Hashing
// Difficulty: Easy
//
// Problem:
// Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution.
//
// Example:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
//
// Approach: HashMap - O(n) Time | O(n) Space

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // No solution found
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        int[] result1 = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Test 1: [" + result1[0] + ", " + result1[1] + "]"); // [0, 1]

        int[] result2 = sol.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Test 2: [" + result2[0] + ", " + result2[1] + "]"); // [1, 2]

        int[] result3 = sol.twoSum(new int[]{3, 3}, 6);
        System.out.println("Test 3: [" + result3[0] + ", " + result3[1] + "]"); // [0, 1]
    }
}
