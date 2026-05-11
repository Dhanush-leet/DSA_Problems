// LeetCode #189 - Rotate Array
// NeetCode: Arrays & Hashing
// Difficulty: Medium
//
// Problem:
// Given an integer array nums, rotate the array to the right by k steps,
// where k is non-negative.
//
// Example 1:
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
//
// Example 2:
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
//
// Approach: Three Reversal Trick - O(n) Time | O(1) Space
// 1. Reverse entire array
// 2. Reverse first k elements
// 3. Reverse remaining n-k elements

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle k >= n

        reverse(nums, 0, n - 1);   // Reverse entire array
        reverse(nums, 0, k - 1);   // Reverse first k elements
        reverse(nums, k, n - 1);   // Reverse remaining elements
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        RotateArray sol = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        sol.rotate(nums1, 3);
        System.out.print("Test 1: ");
        printArray(nums1); // [5,6,7,1,2,3,4]

        int[] nums2 = {-1, -100, 3, 99};
        sol.rotate(nums2, 2);
        System.out.print("Test 2: ");
        printArray(nums2); // [3,99,-1,-100]

        int[] nums3 = {1, 2};
        sol.rotate(nums3, 3);
        System.out.print("Test 3: ");
        printArray(nums3); // [2,1]
    }
}
