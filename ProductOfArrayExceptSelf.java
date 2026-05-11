// LeetCode #238 - Product of Array Except Self
// NeetCode: Arrays & Hashing
// Difficulty: Medium
//
// Problem:
// Given an integer array nums, return an array answer such that
// answer[i] is equal to the product of all elements of nums except nums[i].
// Must run in O(n) time without using the division operator.
//
// Example:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
//
// Approach: Prefix & Suffix Products - O(n) Time | O(1) extra Space

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Fill prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply suffix products from right
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();

        int[] res1 = sol.productExceptSelf(new int[]{1,2,3,4});
        System.out.print("Test 1: ");
        for (int x : res1) System.out.print(x + " "); // 24 12 8 6
        System.out.println();

        int[] res2 = sol.productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.print("Test 2: ");
        for (int x : res2) System.out.print(x + " "); // 0 0 9 0 0
        System.out.println();
    }
}
