// LeetCode #242 - Valid Anagram
// NeetCode: Arrays & Hashing
// Difficulty: Easy
//
// Problem:
// Given two strings s and t, return true if t is an anagram of s,
// and false otherwise. An anagram is a word formed by rearranging
// the letters of another word using all original letters exactly once.
//
// Example 1:
// Input: s = "anagram", t = "nagaram" => Output: true
// Example 2:
// Input: s = "rat", t = "car" => Output: false
//
// Approach: Character Frequency Count - O(n) Time | O(1) Space

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // Only lowercase letters

        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;

        for (int val : count) {
            if (val != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();

        System.out.println("Test 1: " + sol.isAnagram("anagram", "nagaram")); // true
        System.out.println("Test 2: " + sol.isAnagram("rat", "car"));         // false
        System.out.println("Test 3: " + sol.isAnagram("listen", "silent"));   // true
    }
}
