// LeetCode #3 - Longest Substring Without Repeating Characters
// NeetCode: Sliding Window
// Difficulty: Medium
//
// Problem:
// Given a string s, find the length of the longest substring
// without repeating characters.
//
// Example 1:
// Input: s = "abcabcbb" => Output: 3 ("abc")
// Example 2:
// Input: s = "bbbbb"   => Output: 1 ("b")
// Example 3:
// Input: s = "pwwkew"  => Output: 3 ("wke")
//
// Approach: Sliding Window + HashMap - O(n) Time | O(n) Space

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // If char already seen and within current window, shrink from left
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();

        System.out.println("Test 1: " + sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println("Test 2: " + sol.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println("Test 3: " + sol.lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println("Test 4: " + sol.lengthOfLongestSubstring(""));          // 0
    }
}
