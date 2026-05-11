// LeetCode #49 - Group Anagrams
// NeetCode: Arrays & Hashing
// Difficulty: Medium
//
// Problem:
// Given an array of strings strs, group the anagrams together.
// You can return the answer in any order.
//
// Example:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// Approach: Sort each string as key in HashMap - O(n * k log k) Time | O(n*k) Space
// where n = number of strings, k = max string length

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort characters to create a canonical key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to the group for this key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();

        List<List<String>> result1 = sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println("Test 1: " + result1);
        // [[eat, tea, ate], [tan, nat], [bat]]

        List<List<String>> result2 = sol.groupAnagrams(new String[]{""});
        System.out.println("Test 2: " + result2); // [[]]

        List<List<String>> result3 = sol.groupAnagrams(new String[]{"a"});
        System.out.println("Test 3: " + result3); // [[a]]
    }
}
