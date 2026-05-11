// LeetCode #217 - Contains Duplicate
// NeetCode: Arrays & Hashing
// Difficulty: Easy
//
// Problem:
// Given an integer array nums, return true if any value appears
// at least twice in the array, and false if every element is distinct.
//
// Example 1:
// Input: nums = [1,2,3,1] => Output: true
// Example 2:
// Input: nums = [1,2,3,4] => Output: false
//
// Approach: HashSet - O(n) Time | O(n) Space

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();

        System.out.println("Test 1: " + sol.containsDuplicate(new int[]{1,2,3,1}));   // true
        System.out.println("Test 2: " + sol.containsDuplicate(new int[]{1,2,3,4}));   // false
        System.out.println("Test 3: " + sol.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
    }
}
