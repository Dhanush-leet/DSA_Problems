// ============================================================
// Arrays and Strings - LeetCode & NeetCode Problems
// Language: Java
// Topics: Arrays, Strings
// Problems: 10 (LeetCode + NeetCode)
// ============================================================

public class Arrays_and_Strings_DSA {

    // ============================================================
    // PROBLEM 1: Two Sum (LeetCode #1 | NeetCode - Arrays)
    // Difficulty: Easy
    // Given an array of integers and a target, return indices of
    // the two numbers such that they add up to target.
    // ============================================================
    import java.util.HashMap;

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // ============================================================
    // PROBLEM 2: Best Time to Buy and Sell Stock (LeetCode #121 | NeetCode - Sliding Window)
    // Difficulty: Easy
    // Find the maximum profit from buying and selling one stock.
    // ============================================================
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    // ============================================================
    // PROBLEM 3: Contains Duplicate (LeetCode #217 | NeetCode - Arrays)
    // Difficulty: Easy
    // Return true if any value appears at least twice in the array.
    // ============================================================
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return true;
            map.put(num, true);
        }
        return false;
    }

    // ============================================================
    // PROBLEM 4: Product of Array Except Self (LeetCode #238 | NeetCode - Arrays)
    // Difficulty: Medium
    // Return array where each element is product of all other elements.
    // ============================================================
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    // ============================================================
    // PROBLEM 5: Maximum Subarray (LeetCode #53 | NeetCode - Arrays)
    // Difficulty: Medium
    // Find the contiguous subarray with the largest sum (Kadane's Algorithm).
    // ============================================================
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // ============================================================
    // PROBLEM 6: Valid Anagram (LeetCode #242 | NeetCode - Strings)
    // Difficulty: Easy
    // Given two strings s and t, return true if t is an anagram of s.
    // ============================================================
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        for (int val : count) {
            if (val != 0) return false;
        }
        return true;
    }

    // ============================================================
    // PROBLEM 7: Valid Palindrome (LeetCode #125 | NeetCode - Strings)
    // Difficulty: Easy
    // A phrase is a palindrome if it reads the same forward and backward
    // after converting all uppercase to lowercase and removing non-alphanumeric.
    // ============================================================
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ============================================================
    // PROBLEM 8: Longest Substring Without Repeating Characters (LeetCode #3 | NeetCode - Sliding Window)
    // Difficulty: Medium
    // Find the length of the longest substring without repeating characters.
    // ============================================================
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // ============================================================
    // PROBLEM 9: Group Anagrams (LeetCode #49 | NeetCode - Arrays & Hashing)
    // Difficulty: Medium
    // Group strings that are anagrams of each other.
    // ============================================================
    import java.util.*;

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // ============================================================
    // PROBLEM 10: Rotate Array (LeetCode #189 | NeetCode - Arrays)
    // Difficulty: Medium
    // Rotate the array to the right by k steps.
    // ============================================================
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
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

    // ============================================================
    // MAIN METHOD - Quick Test
    // ============================================================
    public static void main(String[] args) {
        Arrays_and_Strings_DSA sol = new Arrays_and_Strings_DSA();

        // Test 1: Two Sum
        int[] result = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Two Sum: [" + result[0] + ", " + result[1] + "]"); // [0, 1]

        // Test 2: Max Profit
        System.out.println("Max Profit: " + sol.maxProfit(new int[]{7,1,5,3,6,4})); // 5

        // Test 3: Contains Duplicate
        System.out.println("Contains Duplicate: " + sol.containsDuplicate(new int[]{1,2,3,1})); // true

        // Test 4: Max Subarray
        System.out.println("Max Subarray: " + sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6

        // Test 5: Valid Anagram
        System.out.println("Is Anagram: " + sol.isAnagram("anagram", "nagaram")); // true

        // Test 6: Valid Palindrome
        System.out.println("Is Palindrome: " + sol.isPalindrome("A man, a plan, a canal: Panama")); // true

        // Test 7: Longest Substring
        System.out.println("Longest Substring: " + sol.lengthOfLongestSubstring("abcabcbb")); // 3

        System.out.println("All tests completed!");
    }
}
